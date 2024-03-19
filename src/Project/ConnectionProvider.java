package Project;

import java.sql.*;
public class ConnectionProvider {
    public static Connection getCon()
    {
    try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","2004Th@k@re");
    return con;
    }
    catch(Exception e)
    { 
    System.out.println(e);
    return null;
            }   
    }
}
if (UserName.getText().isEmpty() && Password.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter Username and Password");
} else if (UserName.getText().isEmpty() || Password.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter All Details");
} else if (UserName.getText().equalsIgnoreCase("Admin") && Password.getText().equals("login123")) {
    new home().setVisible(true);
    this.dispose(); // Make sure 'this' refers to the JFrame you intend to close
} else {
    JOptionPane.showMessageDialog(this, "Wrong Details Entered");
    Password.setText(""); // Consider clearing only the password field
}
