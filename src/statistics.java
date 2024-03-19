import java.sql.*;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

public class statistics extends javax.swing.JFrame {
    public statistics() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Issue Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 21, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Return Details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 212, -1, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, "", null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 127));

        jTable2.setBackground(new java.awt.Color(255, 255, 204));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 680, 127));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red-x-mark-transparent-background-3.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/2.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
        try
        {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("select issue.studentID, student.name, book.name, issue.issueDate, issue.dueDate from student inner join book inner join issue where book.bookID "
                  + "= issue.bookID and student.studentID = issue.studentID and issue.returnBook = 'No'");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            ResultSet rs1=st.executeQuery("select,issue.studentIDs,student.name,book.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID"
                   + "issue.bookID and student.studentID=issue.studentID and issue.returnBook='Yes'");
            jTable2.setModel(DbUtils.resultSetToTableModel(rs1));
        }
            catch(Exception e)  
          {
            JOptionPane.showMessageDialog(null,"Connection Error");
          }            
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new statistics().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private static class JOptionPane {

        private static void showMessageDialog(Object object, String connection_Error) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public JOptionPane() {
        }
    }
}
