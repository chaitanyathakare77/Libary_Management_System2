import java.sql.*;
import java.text.SimpleDateFormat;
import Project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class issueBook extends javax.swing.JFrame {

 public issueBook() {
        initComponents();
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/issue book.png"))); // NOI18N
        jButton1.setText("Issue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red-x-mark-transparent-background-3.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 201, 30));

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 201, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Book ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Student ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Issue Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Due Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 280, 70, 40));

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 204));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 201, 30));

        jDateChooser2.setForeground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 201, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/2.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                       
    SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
    String bookID = jTextField1.getText();
    String studentID = jTextField2.getText();
    String issueDate = dFormat.format(jDateChooser1.getDate());
    String dueDate = dFormat.format(jDateChooser2.getDate());
    String returnBook = "No";
   try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from book where bookID='" + bookID + "'");
        if (rs.next()) {
            ResultSet rs1 = st.executeQuery("select * from student where studentID='" + studentID + "'");
            if (rs1.next()) {
                st.executeUpdate("insert into issue values('" + bookID + "','" + studentID + "','" + issueDate + "','" + dueDate + "','" + returnBook + "')");
                JOptionPane.showMessageDialog(null, "Book successfully issued");
                setVisible(false);
                new issueBook().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect studentID");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect bookID");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Connection error");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

        public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new issueBook().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
