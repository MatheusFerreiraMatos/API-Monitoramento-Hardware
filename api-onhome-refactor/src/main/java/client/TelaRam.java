package client;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Ram;

/**
 *
 * @author Matheus Mattos
 */
public class TelaRam extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaRam() {
        initComponents();
        Ram infoRam = new Ram();

        // Variaveis para adicionar "favicon" na barra superior da página;
        URL caminhoImagem = this.getClass().getClassLoader().getResource("logo-casa.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);

        Timer timer = new Timer();
        Integer delay = 1000;
        Integer interval = 1000;

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                respostaTotalMemoria.setText(String.format("%.2f Gb", infoRam.getTotalMemoria()));
                respostaMemoriaLivre.setText(String.format("%.2f Gb", infoRam.getMemoriaLivre()));
                respostaUsabilidade.setText(String.format("%.2f %%", infoRam.getUsabilidade()));
            }
        }, delay, interval);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleMonitoramento = new javax.swing.JLabel();
        buttonCpu = new javax.swing.JButton();
        buttonDisco = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        titleInfoMaquina = new javax.swing.JLabel();
        titleTotalMemoria = new javax.swing.JLabel();
        respostaTotalMemoria = new javax.swing.JLabel();
        titleMemoriaLivre = new javax.swing.JLabel();
        respostaMemoriaLivre = new javax.swing.JLabel();
        titleUsabilidade = new javax.swing.JLabel();
        respostaUsabilidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 4, 37));

        titleMonitoramento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleMonitoramento.setForeground(new java.awt.Color(255, 255, 255));
        titleMonitoramento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleMonitoramento.setText("Monitoramento");

        buttonCpu.setBackground(new java.awt.Color(255, 255, 255));
        buttonCpu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonCpu.setText("CPU");
        buttonCpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCpuActionPerformed(evt);
            }
        });

        buttonDisco.setBackground(new java.awt.Color(255, 255, 255));
        buttonDisco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonDisco.setText("Disco");
        buttonDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDiscoActionPerformed(evt);
            }
        });

        buttonSair.setBackground(new java.awt.Color(255, 255, 255));
        buttonSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSair.setText("Voltar");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(titleMonitoramento, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleMonitoramento, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        titleInfoMaquina.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleInfoMaquina.setForeground(new java.awt.Color(8, 4, 37));
        titleInfoMaquina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleInfoMaquina.setText("Hardware RAM");

        titleTotalMemoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleTotalMemoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTotalMemoria.setText("Total de Memória:");

        respostaTotalMemoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        respostaTotalMemoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        respostaTotalMemoria.setText("...");

        titleMemoriaLivre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleMemoriaLivre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleMemoriaLivre.setText("Memória Livre:");

        respostaMemoriaLivre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        respostaMemoriaLivre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        respostaMemoriaLivre.setText("...");

        titleUsabilidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleUsabilidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleUsabilidade.setText("Usabilidade:");

        respostaUsabilidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        respostaUsabilidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        respostaUsabilidade.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleInfoMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleTotalMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(respostaTotalMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleMemoriaLivre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(respostaMemoriaLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleUsabilidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(respostaUsabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleInfoMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleTotalMemoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(respostaTotalMemoria))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleMemoriaLivre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(respostaMemoriaLivre)))
                .addGap(30, 30, 30)
                .addComponent(titleUsabilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(respostaUsabilidade)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(834, 362));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // TODO add your handling code here:
        TelaPrincipal telaPrincipal = null;
        try {
            telaPrincipal = new TelaPrincipal();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaRam.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonCpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCpuActionPerformed
        // TODO add your handling code here:
        TelaCpu telaCpu = new TelaCpu();
        telaCpu.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCpuActionPerformed

    private void buttonDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiscoActionPerformed
        // TODO add your handling code here:
        TelaDisco telaDisco = new TelaDisco();
        telaDisco.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonDiscoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCpu;
    private javax.swing.JButton buttonDisco;
    private javax.swing.JButton buttonSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel respostaMemoriaLivre;
    private javax.swing.JLabel respostaTotalMemoria;
    private javax.swing.JLabel respostaUsabilidade;
    private javax.swing.JLabel titleInfoMaquina;
    private javax.swing.JLabel titleMemoriaLivre;
    private javax.swing.JLabel titleMonitoramento;
    private javax.swing.JLabel titleTotalMemoria;
    private javax.swing.JLabel titleUsabilidade;
    // End of variables declaration//GEN-END:variables
}