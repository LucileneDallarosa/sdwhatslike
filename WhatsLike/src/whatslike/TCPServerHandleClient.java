package whatslike;

/** Simple thread to handle server socket connections
 
 Author: Avelino F. Zorzo
 avelino.zorzo@pucrs.br
 
 Date: 10.03.2018
 Modified: 10.03.2018
 
 **/

import java.io.PrintStream;
import java.io.DataInputStream;
import java.net.Socket;

public class TCPServerHandleClient extends Thread {
    Socket clientSocket;
    
    public TCPServerHandleClient(Socket s) {
        clientSocket = s;
    }
    
   public void run() {
    
     try {
      
        // creates input and output stream from the client socket.
        PrintStream     os = new PrintStream(clientSocket.getOutputStream());
        DataInputStream is = new DataInputStream(clientSocket.getInputStream());
         
        // prints data sent by the client
        System.out.println(clientSocket.getInetAddress().getHostAddress()+": "+is.readLine());
        // sends data to the client
        os.println(clientSocket.getInetAddress().getHostAddress()+" got your data!");
        // closes connection
        clientSocket.close();
      
     } catch(Exception e) {
        System.err.println("Error in client "+clientSocket.getInetAddress().getHostAddress());
     }
   }
}

