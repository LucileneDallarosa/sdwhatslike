
package whatslike;

import java.net.ServerSocket;
import java.net.Socket;
import whatslike.TCPServerHandleClient;

/**
 *
 * @author 11204785
 */
public class Servidor {
    public static void main(String[] args) {
      try {
          if (args.length < 1) {
              System.err.println("Please use: Java TCPServer <port>");
              System.exit(1);
          }
         
          // creates a server socket to listen to connections: parameter - port number
         ServerSocket server = new ServerSocket(Integer.parseInt(args[0]));
         System.out.println("Server waiting connections at port "+ args[0]);
         
        // waits connections from several clients
         while (true) {
            // accepts a connection from the client
            Socket client = server.accept();
            System.out.println("Client address: " + client.getInetAddress().getHostAddress());
             
            // creates a thread to handle this connection
            TCPServerHandleClient handleThread = new TCPServerHandleClient(client);
            handleThread.start();
             
         }
      
      } catch(Exception e) {
          System.err.println("Error in server: " + e.getMessage());
      }
   }
}
