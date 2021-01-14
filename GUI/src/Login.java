import java.awt.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.*;

/*
 * Created by JFormDesigner on Thu Jan 14 13:05:18 CET 2021
 */



/**
 * @author Pini
 */
public class Login extends JFrame {
    public Login() {
          initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Pini
        dUserName = new JLabel();
        userNameField = new JTextField();
        dPassword = new JLabel();
        passwordField = new JTextField();
        loginButton = new JButton();
        dManage = new JLabel();
        adminCombo = new JComboBox();
        roleLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("Log In");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- dUserName ----
        dUserName.setText("User Name");
        contentPane.add(dUserName);
        dUserName.setBounds(70, 35, 90, 20);
        contentPane.add(userNameField);
        userNameField.setBounds(170, 30, 150, userNameField.getPreferredSize().height);

        //---- dPassword ----
        dPassword.setText("Password");
        contentPane.add(dPassword);
        dPassword.setBounds(75, 75, 60, 20);
        contentPane.add(passwordField);
        passwordField.setBounds(170, 70, 145, 30);

        //---- loginButton ----
        loginButton.setText("Log In");
        contentPane.add(loginButton);
        loginButton.setBounds(new Rectangle(new Point(235, 110), loginButton.getPreferredSize()));

        //---- dManage ----
        dManage.setText("Manage");
        contentPane.add(dManage);
        dManage.setBounds(85, 200, 60, 21);
        contentPane.add(adminCombo);
        adminCombo.setBounds(new Rectangle(new Point(170, 195), adminCombo.getPreferredSize()));
        contentPane.add(roleLabel);
        roleLabel.setBounds(165, 110, 60, 30);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Pini
    private JLabel dUserName;
    private JTextField userNameField;
    private JLabel dPassword;
    private JTextField passwordField;
    private JButton loginButton;
    private JLabel dManage;
    private JComboBox adminCombo;
    private JLabel roleLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main (String[] args) {

        DataBase db = new DataBase();
        db.open();
        //db.createTable2("user", "password");
        db.insertUser("admin", "admin");
        db.deleteUser("fdf");
        db.deleteUser("admin");
       // Login log = new Login();
       // log.setVisible(true);

    }
}

