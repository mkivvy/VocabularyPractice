/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vocabularypractice;

import javax.swing.JOptionPane;

/**
 *
 * @author Mary
 */
public class VocabularyPracticeWindow extends javax.swing.JFrame {

    private static final int WINDOW_X = 400;
    private static final int WINDOW_Y = 200;
    private static final int WINDOW_WIDTH = 422;
    private static final int WINDOW_HEIGHT = 370;

    private static final String CONFIRM_EXIT_TITLE = "Confirm system exit";
    private static final String CONFIRM_EXIT_MSG = "Are you sure you want to exit?";
    
    /**
     * Creates new form VocabularyPracticeWindow
     */
    public VocabularyPracticeWindow() {
        initComponents();
        //Size & position window: top left x&y, width, height
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT); 
//        prepareHeaderPanel(companyName, garageNum);
//        displayWelcomePanel();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgChooseAction = new javax.swing.ButtonGroup();
        pnlWelcome = new javax.swing.JPanel();
        lblChooseOne = new javax.swing.JLabel();
        optPractice = new javax.swing.JRadioButton();
        optEdit = new javax.swing.JRadioButton();
        optExit = new javax.swing.JRadioButton();
        pnlHeader = new javax.swing.JPanel();
        lblVocabularyPractice = new javax.swing.JLabel();
        pnlSelectFile = new javax.swing.JPanel();
        jFileChooserVocab = new javax.swing.JFileChooser();

        setBackground(new java.awt.Color(153, 255, 153));

        pnlWelcome.setBackground(new java.awt.Color(204, 255, 204));
        pnlWelcome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 1, true));

        lblChooseOne.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        lblChooseOne.setForeground(new java.awt.Color(0, 153, 0));
        lblChooseOne.setText("I want to:");

        optPractice.setBackground(new java.awt.Color(204, 255, 204));
        btgChooseAction.add(optPractice);
        optPractice.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        optPractice.setForeground(new java.awt.Color(51, 51, 255));
        optPractice.setSelected(true);
        optPractice.setText("Practice Vocabulary");

        optEdit.setBackground(new java.awt.Color(204, 255, 204));
        btgChooseAction.add(optEdit);
        optEdit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        optEdit.setForeground(new java.awt.Color(51, 51, 255));
        optEdit.setText("Edit Terms & Definitions");

        optExit.setBackground(new java.awt.Color(204, 255, 204));
        btgChooseAction.add(optExit);
        optExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        optExit.setForeground(new java.awt.Color(51, 51, 255));
        optExit.setText("EXIT ");
        optExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChooseOne)
                    .addGroup(pnlWelcomeLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optEdit)
                            .addComponent(optPractice)
                            .addComponent(optExit))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblChooseOne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optPractice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optExit)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pnlHeader.setBackground(new java.awt.Color(153, 255, 255));
        pnlHeader.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));

        lblVocabularyPractice.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblVocabularyPractice.setForeground(new java.awt.Color(51, 51, 255));
        lblVocabularyPractice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVocabularyPractice.setText("Vocabulary Practice");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVocabularyPractice, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVocabularyPractice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSelectFile.setBackground(new java.awt.Color(204, 255, 204));
        pnlSelectFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));

        jFileChooserVocab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserVocabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelectFileLayout = new javax.swing.GroupLayout(pnlSelectFile);
        pnlSelectFile.setLayout(pnlSelectFileLayout);
        pnlSelectFileLayout.setHorizontalGroup(
            pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectFileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooserVocab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSelectFileLayout.setVerticalGroup(
            pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectFileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooserVocab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSelectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSelectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Vocabulary Practice Window");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optExitActionPerformed
// If there are any open connections/files, close them first        
        System.exit(0); 
//        int option = JOptionPane.showConfirmDialog(this, CONFIRM_EXIT_MSG, 
//                CONFIRM_EXIT_TITLE, JOptionPane.YES_NO_OPTION, 
//                JOptionPane.WARNING_MESSAGE);
//        if (option == JOptionPane.YES_OPTION) {
//            System.exit(0); 
//        }
    }//GEN-LAST:event_optExitActionPerformed

    private void jFileChooserVocabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserVocabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooserVocabActionPerformed

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
            java.util.logging.Logger.getLogger(VocabularyPracticeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VocabularyPracticeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VocabularyPracticeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VocabularyPracticeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VocabularyPracticeWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgChooseAction;
    private javax.swing.JFileChooser jFileChooserVocab;
    private javax.swing.JLabel lblChooseOne;
    private javax.swing.JLabel lblVocabularyPractice;
    private javax.swing.JRadioButton optEdit;
    private javax.swing.JRadioButton optExit;
    private javax.swing.JRadioButton optPractice;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlSelectFile;
    private javax.swing.JPanel pnlWelcome;
    // End of variables declaration//GEN-END:variables
}
