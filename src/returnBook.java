import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class returnBook extends javax.swing.JFrame {

     public returnBook() {
        initComponents();
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Book ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Student ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Issue Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Due Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, 30));

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 220, 30));

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 220, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 130, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/return book png.png"))); // NOI18N
        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red-x-mark-transparent-background-3.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 230, 30));

        jDateChooser2.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 240, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/2.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 700, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String bookID=jTextField1.getText();
        String studentID=jTextField2.getText();
        String issueDate = dFormat.format(jDateChooser1.getDate());
        String dueDate = dFormat.format(jDateChooser2.getDate());
         try
               {
               Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("update issue set returnBook='Yes' where studentID='"+studentID+"' and BookID='"+bookID+"'");
            JOptionPane.showMessageDialog(null,"Book successfully returned");
            setVisible(false);
            new returnBook().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
            catch(Exception e)
     {
            JOptionPane.showMessageDialog(null,"Connection Error");
     }
     }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
               String bookID=jTextField1.getText();
               String studentID=jTextField2.getText();
       try
            {
               Connection con=ConnectionProvider.getCon();
               Statement st=con.createStatement();
               ResultSet rs1=st.executeQuery("selete 'from book where bookID='"+bookID+"'and studentID='"+studentID"');
               if(rs.next())
            {
               jTextField3.setText(rs.getString(3));
               jTextField4.setText(rs.getString(4));
               jTextField1.setEditable(false);
               jTextField2.setEditable(false);
            }
               else
            {
               JOptionPane.showMessageDialog(null,"Book is not issued to this student ");
               setVisible(false);
               new returnBook().setVisible(true);
            }
            }     
               catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"Connection Error");
            }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new returnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private static class rs {
        private static boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private static String getString(int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        public rs() {
        }
    }
}
