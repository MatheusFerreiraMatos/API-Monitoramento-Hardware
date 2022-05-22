package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael.ramos
 */
public class Log {

    private static String folder;
    private static File logFile;
    private static String filePath;

    public static void createDirectory() {
        folder = "log";
        new File(folder).mkdir();
    }

    public void createFile() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            filePath = folder + "/" + format.format(Calendar.getInstance().getTime()) + ".log";
            logFile = new File(filePath);
            logFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void append(String text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileWriter writter;
                DateTimeFormatter data = DateTimeFormatter.ofPattern("uuuu-MM-dd");
                LocalDate localDate = LocalDate.now();

                DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.now();
                try {
                    writter = new FileWriter(filePath, true);
                    writter.write(String.format("[%s] %s: %s\n", data.format(localDate), hora.format(localTime), text));
                    writter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
