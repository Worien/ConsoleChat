import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by pavel on 3/11/15.
 */
public class ClientChatReader implements Runnable {
    Socket socket;
    String name;
    public ClientChatReader(Socket socket, String name){
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {


        try {
            InputStream sin = socket.getInputStream();
            DataInputStream in = new DataInputStream(sin);
            String ansver = null;
            while (true){
                ansver = in.readUTF();
                System.out.println(ansver);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
