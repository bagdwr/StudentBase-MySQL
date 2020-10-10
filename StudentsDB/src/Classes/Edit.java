package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends Container {
    private JButton EditButton,BackButton,DeleteButton;
    private JLabel fullnameLabel,groupLabel,facultyLabel,IdLabel;
    private String[] faculties={"ITSE","ITML","RET","SIS","CS"};
    private JComboBox facultiesComboBox;
    private JTextField fullnameField,groupField,idField;
    private JButton addButton,cancelButton,findButton;
    private Student student;
    public Edit() {
        setVisible(true);
        setLayout(null);
        setSize(450,350);

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,15);
        IdLabel=new JLabel("ID");
        IdLabel.setFont(font);
        IdLabel.setBounds(40,25,110,25);
        add(IdLabel);

        idField=new JTextField();
        idField.setFont(font);
        idField.setBounds(140,25,200,25);
        add(idField);

        findButton=new JButton("Find");
        findButton.setFont(font);
        findButton.setBounds(350,25,80,25);
        add(findButton);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd=new PackageData("LIST");
                Main.connect(pd);
                for(int i=0; i<Main.users.size(); i++)
                {
                    if(Main.students.get(i).getId() == Integer.parseInt(idField.getText()))
                    {
                        student=new Student(Main.students.get(i).getId(),Main.students.get(i).getFullname(),
                        Main.students.get(i).getFaculty(),Main.students.get(i).getGroup());
                        fullnameField.setText(student.getFullname());
                        groupField.setText(student.getGroup());
                        facultiesComboBox.setSelectedItem(student.getFaculty());
                    }
                }
            }
        });

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

        addButton=new JButton("Save");
        addButton.setBounds(80,220,100,25);
        addButton.setFont(font);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancelButton=new JButton("Back");
        cancelButton.setBounds(240,220,100,25);
        cancelButton.setFont(font);
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.editWindow.setVisible(false);
                MainFrame.mainWindow.setVisible(true);
            }
        });

        DeleteButton=new JButton("Delete");
        DeleteButton.setFont(font);
        DeleteButton.setBounds(160,270,100,25);
        add(DeleteButton);
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!student.getFullname().isEmpty()) {
                    PackageData pd = new PackageData("Delete");
                    pd.setId(student.getId());
                    Main.connect(pd);
                    idField.setText("");
                    groupField.setText("");
                    fullnameField.setText("");
                }
            }
        });
    }
}
