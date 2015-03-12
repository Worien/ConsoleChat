import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by pavel on 3/11/15.
 */
public class ClientChatWriter implements Runnable {
    Socket socket;
    String name;

    public ClientChatWriter(Socket socket, String name){
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            OutputStream out = socket.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);
            String line = null;
            while (true){
                line = keyboard.readLine();
                dout.writeUTF(name+": "+line);
                dout.flush();
            }


        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
