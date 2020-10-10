package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List extends Container {
    private JButton List,Back;
    private JTextArea ListArea;
    public List()
    {
        setSize(450,350);
        setLayout(null);
        setVisible(true);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        ListArea=new JTextArea();
        ListArea.setBounds(10,10,410,250);
        add(ListArea);

        List=new JButton("List");
        List.setBounds(80,270,100,25);
        List.setFont(font);
        add(List);
        List.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    PackageData packageData=new PackageData("LIST");
                    Main.connect(packageData);
                String s="";
                for(int i=0; i<Main.students.size(); i++)
                {
                    s=s+Main.students.get(i);
                }
                ListArea.setText(s);
            }
        });

        Back=new JButton("Back");
        Back.setBounds(250,270,100,25);
        Back.setFont(font);
        add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListArea.setText("");
                MainFrame.mainWindow.setVisible(true);
                MainFrame.listWindow.setVisible(false);
            }
        });
    }
}
