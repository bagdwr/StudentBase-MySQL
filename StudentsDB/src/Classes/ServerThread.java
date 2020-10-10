package Classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread implements Serializable {
    private Socket socket;
    public ServerThread(Socket socket)
       {
           this.socket=socket;
       }
    public void run()
    {
        try {
            DBmanager dBmanager=new DBmanager();
            dBmanager.connect();
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            PackageData pd=null;
            while ((pd=(PackageData)inputStream.readObject())!=null)
            {
                if(pd.getOperationType().equals("ADD"))
                {
                    dBmanager.AddStudent(pd.getStudent());
                }
                if(pd.getOperationType().equals("LIST"))
                {
                    PackageData toClient=new PackageData();
                    toClient.setAllStudents(dBmanager.getAllStudents());
                    outputStream.writeObject(toClient);
                }
                if(pd.getOperationType().equals("Add_user"))
                {
                    dBmanager.AddUser(pd.getUser());
                }
                if(pd.getOperationType().equals("List_user"))
                {
                    PackageData toClient=new PackageData();
                    toClient.setAllUsers(dBmanager.getAllUsers());
                    outputStream.writeObject(toClient);
                }
                if (pd.getOperationType().equals("Delete"))
                {
                    dBmanager.DeleteById(pd.getId());
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
