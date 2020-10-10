package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends Container {
    private JTextField loginField;
    private JLabel loginLabel, passwordLabel;
    private JPasswordField passwordField;
    private JButton signInButton, signUpButton;
    private JCheckBox box;

    public MainWindow() {
        setSize(450,350);
        setLayout(null);


        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(40, 90, 110, 25);
        loginLabel.setFont(font);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(140, 90, 200, 25);
        add(loginField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 130, 110, 25);
        passwordLabel.setFont(font);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 130, 200, 25);
        passwordField.setEchoChar('*');
        add(passwordField);

        box = new JCheckBox("Show password");
        box.setBounds(137, 160, 200, 25);
        add(box);
        box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (box.isSelected())
                    passwordField.setEchoChar((char) 0);
                else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        signInButton = new JButton("sign in");
        signInButton.setBounds(140, 200, 80, 25);
        add(signInButton);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login=loginField.getText();
                String password=passwordField.getText();
                boolean f=false;
                if(!login.isEmpty() && !password.isEmpty()) {
                    PackageData pd=new PackageData("List_user");
                    Main.connect(pd);
                    for (int i = 0; i < Main.users.size(); i++) {
                        if (Main.users.get(i).getLogin().equals(login) && Main.users.get(i).getPassword().equals(password)) {
                            f = true;
                        }
                    }
                    if (f) {
                        MainFrame.mainMenuWindow.setVisible(false);
                        MainFrame.mainWindow.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid account\nTry again...");
                    }
                }
                loginField.setText("");
                passwordField.setText("");
            }
        });
        signUpButton = new JButton("sign up");
        signUpButton.setBounds(260, 200, 80, 25);
        add(signUpButton);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.registrationWindow.setVisible(true);
                MainFrame.mainMenuWindow.setVisible(false);
            }
        });
    }
}