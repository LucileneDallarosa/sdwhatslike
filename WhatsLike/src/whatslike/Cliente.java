package whatslike;

import java.io.PrintStream;
import java.io.DataInputStream;
import java.net.Socket;

/**
 *
 * @author 11204785
 */
public class Cliente {
    public static void main(String[] args) {
            try {
                if (args.length < 3) {
                    System.err.println("Please use: Java TCPClient <server address> <port> <message>");
                    System.exit(1);
                }
                // create socket to connect to server - parameters: server ip and port number
                Socket server = new Socket(args[0],Integer.parseInt(args[1]));
                
                //create streams to send and read data from the socket
                PrintStream     os = new PrintStream(server.getOutputStream());
                DataInputStream is = new DataInputStream(server.getInputStream());
                
                // writes a message to the stream connected to the socket
                os.println(args[2]);
                
                // reads data sent by the server
                System.out.println(is.readLine());
                
                // closes connection
                server.close();
                System.out.println("Connection ended!");
            }
            catch(Exception e) {
                System.err.println("Error in client: " + e.getMessage());
            }
        }
}
