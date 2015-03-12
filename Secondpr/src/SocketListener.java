import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pavel on 3/11/15.
 */
public class SocketListener implements Runnable {
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int port = 7777;
            ServerSocket ss = new ServerSocket(port);
            while (true){
                Socket socket = ss.accept();
                SecondClass.list.add(socket);
                Server s = new Server(socket);
                new Thread(s).start();


                System.out.println("Got a client... Finnally, someone saw me through all the cover");
                System.out.println();
            }




        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
