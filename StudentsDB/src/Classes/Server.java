package Classes;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Serializable{
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket=new ServerSocket(8878);
            System.out.println("Waiting for a client");
            while (true)
            {
                Socket socket=serverSocket.accept();
                System.out.println("Client connected");
                ServerThread st=new ServerThread(socket);
                st.start();
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
