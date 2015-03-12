import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pavel on 3/9/15.
 */
public class Client {
    public static void main(String[] args) {



        String name = "Client 1";
        int serverPort = 7777;
        String address = "127.0.0.1";

        try{
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Any of you heard of a socket with IP address "+address+"and port"+serverPort+"?");
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Yes, Im just got hold of the program!");
            ClientChatReader reader = new ClientChatReader(socket, name);
            ClientChatWriter writer = new ClientChatWriter(socket, name);
            Executor ex = Executors.newFixedThreadPool(2);
            ex.execute(reader);
            ex.execute(writer);



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    }

