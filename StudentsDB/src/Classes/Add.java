package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends Container {
    private JLabel fullnameLabel,groupLabel,facultyLabel;
    private String[] faculties={"ITSE","ITML","RET","SIS","CS"};
    private JComboBox facultiesComboBox;
    private JTextField fullnameField,groupField;
    private JButton addButton,cancelButton;
    public Add()
    {
        setSize(450,350);
        setLayout(null);
        setVisible(true);

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,15);
        JLabel AddStud= new JLabel("Add Student");
        AddStud.setFont(font);
        AddStud.setBounds(180,20,100,25);
        add(AddStud);

        fullnameLabel=new JLabel("Fullname");
        fullnameLabel.setFont(font);
        fullnameLabel.setBounds(40,70,110,25);
        add(fullnameLabel);

        fullnameField=new JTextField();
        fullnameField.setBounds(140,70,200,25);
        fullnameField.setFont(font);
        add(fullnameField);

        facultyLabel=new JLabel("Faculty");
        facultyLabel.setFont(font);
        facultyLabel.setBounds(40,120,110,25);
        add(facultyLabel);

        facultiesComboBox=new JComboBox(faculties);
        facultiesComboBox.setBounds(140,120,200,25);
        facultiesComboBox.setBackground(Color.WHITE);
        facultiesComboBox.setFont(font);
        add(facultiesComboBox);

        groupLabel=new JLabel("group");
        groupLabel.setFont(font);
        groupLabel.setBounds(40,170,110,25);
        add(groupLabel);

        groupField=new JTextField();
        groupField.setBounds(140,170,200,25);
        add(groupField);
        groupField.setFont(font);

        addButton=new JButton("Add");
        addButton.setBounds(80,220,100,25);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  Student student=new Student(null,
                          fullnameField.getText(),
                          (String)facultiesComboBox.getSelectedItem(),
                          groupField.getText());
                  if(student.getFullname().isEmpty() || student.getGroup().isEmpty())
                  {
                      JOptionPane.showMessageDialog(null,"There is an empty field");
                  }
                  else
                  {
                      PackageData packageData=new PackageData("ADD",student);
                      Main.connect(packageData);
                      fullnameField.setText("");
                      groupField.setText("");
                      facultiesComboBox.setSelectedItem(1);
                  }

            }
        });

        cancelButton=new JButton("Back");
        cancelButton.setBounds(240,220,100,25);
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addWindow.setVisible(false);
                MainFrame.mainWindow.setVisible(true);
            }
        });
    }
}
