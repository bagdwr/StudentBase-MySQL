package Classes;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu mainWindow;
    public static Add addWindow;
    public static List listWindow;
    public static Edit editWindow;
    public static RegistrationMenu registrationWindow;
    public static MainWindow mainMenuWindow;


    public MainFrame(){
        setTitle("StudentsBase");
        setResizable(false);
        setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        mainMenuWindow=new MainWindow();
        mainMenuWindow.setLocation(0,0);
        mainMenuWindow.setVisible(true);
        add(mainMenuWindow);

        mainWindow=new MainMenu();
        mainWindow.setVisible(false);
        mainWindow.setLocation(0,0);
        add(mainWindow);

        addWindow=new Add();
        addWindow.setLocation(0,0);
        addWindow.setVisible(false);
        add(addWindow);

        listWindow=new List();
        listWindow.setLocation(0,0);
        listWindow.setVisible(false);
        add(listWindow);

        editWindow=new Edit();
        editWindow.setLocation(0,0);
        editWindow.setVisible(false);
        add(editWindow);

        registrationWindow=new RegistrationMenu();
        registrationWindow.setLocation(0,0);
        registrationWindow.setVisible(false);
        add(registrationWindow);

    }
}
