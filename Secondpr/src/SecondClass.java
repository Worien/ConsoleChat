/**
 * Created by pavel on 1/2/15.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SecondClass {

    public static ArrayList<Socket> list = new ArrayList<Socket>();


        public static void main(String[] args) throws Exception
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            SocketListener listener = new SocketListener();
            Executor ex = Executors.newCachedThreadPool();
            ex.execute(listener);


            String l = null;
            while (true){
                    l = reader.readLine();

                    for (int i = 0; i < list.size(); i++) {
                        DataOutputStream dout = new DataOutputStream(list.get(i).getOutputStream());
                        dout.writeUTF(l);
                        dout.flush();
                    }
            }
        }

    }


