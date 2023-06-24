import java.io.*;
import java.net.*;
import java.util.*;

public class client
{
    public static void main(String[] args) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost(); //IP address of server=local host beca
        // use server and client on same system
        int port = 4444; //port number

        Scanner sc = new Scanner(System.in);

        Socket s = new Socket(ip, port); //client socket connection

        DataInputStream dis = new DataInputStream(s.getInputStream()); //returning input stream attached to socket s
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); //returning output stream attached to socket s

        System.out.println("---------------------------------");

        while (true)
        {
            System.out.println("1.Character to ASCII Conversion");
            System.out.println("2.ASCII to Character Conversion");
            System.out.println("3.Exit");
            System.out.println("---------------------------------");

            int option = sc.nextInt();

            if(option==1) //character to ascii conversion
            {
                System.out.println("Enter a character:");
                char character=sc.next().charAt(0);
                dos.writeInt(option);
                dos.writeChar(character);

                String ascii=dis.readUTF();
                System.out.println("ASCII Code of Character is: " + ascii);
                System.out.println("------------------------------------");
            }

            else if(option==2) //ascii to character conversion
            {
                System.out.println("Enter ASCII code:");
                int ascii=sc.nextInt();
                dos.writeInt(option);
                dos.writeInt(ascii);

                String character=dis.readUTF();
                System.out.println("Character correspoding to ASCII code is: " + character);
                System.out.println("-----------------------------------------------------");
            }

            else if(option==3) //Ending Connection
            {
                dos.writeInt(option);
                break;
            }

            else
            {
                System.out.println("Enter a valid Option!");
                System.out.println("---------------------");
            }
        }

        System.out.println("Ending Connection");
        System.out.println("--------------------");
        s.close();
    }
}