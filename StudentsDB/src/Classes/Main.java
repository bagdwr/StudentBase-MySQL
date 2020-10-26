package Classes;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Main implements Serializable {
    public static MainFrame frame;
    public static  ArrayList<Users>users=new ArrayList<>();
    public static  ArrayList<Student>students=new ArrayList<>();
    public static void connect(PackageData packageData)
    {
        try{
            Socket socket=new Socket("127.0.0.1",8888);
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            if(packageData.getOperationType().equals("ADD"))
            {
                outputStream.writeObject(packageData);
            }
            if(packageData.getOperationType().equals("LIST"))
            {
                outputStream.writeObject(packageData);
                PackageData pdFromServer=(PackageData)inputStream.readObject();
                students=pdFromServer.getStudents();
            }
            if(packageData.getOperationType().equals("Add_user"))
            {
                outputStream.writeObject(packageData);
            }
            if(packageData.getOperationType().equals("List_user"))
            {
                outputStream.writeObject(packageData);
                PackageData pdFromServer=(PackageData)inputStream.readObject();
                users=pdFromServer.getAllUsers();
            }
            if(packageData.getOperationType().equals("Delete"))
            {
                outputStream.writeObject(packageData);
            }
            if (packageData.getOperationType().equals("Update"))
            {
                outputStream.writeObject(packageData);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        frame=new MainFrame();
        frame.setVisible(true);
    }
}
