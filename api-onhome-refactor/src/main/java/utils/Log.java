/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Log extends PrintStream {
    public static List<String> list = new ArrayList<>();
    private static PrintStream orig = System.out;
    
    private static String folder;
    private static File logFile;
    private static String filePath;
    
    public Log() {
        super(System.out, true);
        System.out.println("-".repeat(30));
        System.out.println("Created by github.com/msuttobr");
        System.out.println("Logger started in class: " + this.getClass().getName());
        createDirectory();
        createFile();
    }

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
    public void println(String s) {
        list.add(s);
        append(s);
    }
}
