import java.io.*;
import java.net.*;
import java.util.*;

public class server
{
    public static void main(String args[]) throws IOException {

        ServerSocket ss = new ServerSocket(4444); //server socket waiting for requests for port number 4444
        Socket s = ss.accept(); //accepting client request

        DataInputStream dis = new DataInputStream(s.getInputStream()); //returning inputstream attached to socket s
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); //returning outputstream attached to socket s

        System.out.println("----------------------------------");

        while (true)
        {
            int option=dis.readInt(); //reading option

            if(option==1) //character to ascii conversion
            {
                char c1=dis.readChar();
                int ascii=(int)c1;
                System.out.println("Sending ASCII code for character "+c1);
                System.out.println("--------------------------------------");
                dos.writeUTF(Integer.toString(ascii));
            }

            else if(option==2) //ascii to character conversion
            {
                int ascii=dis.readInt();
                char c1=(char)ascii;
                System.out.println("Sending character corresponding to ASCII code " + ascii) ;
                System.out.println("--------------------------------------------------------");
                dos.writeUTF(Character.toString(c1));
            }
            else if(option==3) //closing connection
            {
                break;
            }

        }

        System.out.println("Ending Connection");
        System.out.println("-------------------");
        ss.close();
        s.close();
    }
}