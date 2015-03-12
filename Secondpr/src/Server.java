import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pavel on 3/10/15.
 */
public class Server implements Runnable {

    Socket s;

    public Server(Socket socket){

        this.s = socket;
    }

    @Override
    public void run() {

        try{

            Socket socket = s;


            InputStream sin = socket.getInputStream();

            OutputStream sout = socket.getOutputStream();


            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true){
                line = in.readUTF();
                for (int i = 0; i < SecondClass.list.size(); i++) {
                    DataOutputStream dout = new DataOutputStream(SecondClass.list.get(i).getOutputStream());
                    dout.writeUTF(line);
                    dout.flush();
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
