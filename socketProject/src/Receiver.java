
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Receiver { 
    private static int port = 3333;
    private static int port2 = 3334;
     private static int port3 = 3335;
    private static ServerSocket serverSocket;
    private static ServerSocket serverSocket2;
     private static ServerSocket serverSocket3;
    public static void main(String[] args) throws IOException {
        ServerAcces();
    }
    private static void ServerAcces() throws IOException  {
        Socket link= null;
        Socket link2= null;
        Socket link3= null;
        serverSocket = new ServerSocket(port);
        serverSocket2 = new ServerSocket(port2);
        serverSocket3 = new ServerSocket(port3);
        try{
         link = serverSocket.accept();
         link2 = serverSocket2.accept();
         link3 = serverSocket3.accept();
           System.out.println("connectd accept...");
        }catch(IOException e){
            System.out.println("unable to read data..");
        }    
        Scanner input[] = {new Scanner(link.getInputStream()),new Scanner(link2.getInputStream()),new Scanner(link3.getInputStream())};
        PrintWriter output[] = {new PrintWriter(link.getOutputStream(),true),new PrintWriter(link2.getOutputStream(),true),new PrintWriter(link3.getOutputStream(),true)};
        int i=0;
        int attempt = 0;
        String ACK = "ack ";
        String massage= " ";
           while(!massage.equalsIgnoreCase("close")){
                    if(i > 2 ){ i = 0;};
                    massage = input[i].nextLine();
                    System.out.println(" client: " +massage);
                    output[i].println(ACK+attempt);
                    output[i].flush();
                    if(massage.equalsIgnoreCase("CLOSE")){
                        break;
                    }
                    massage = input[i].nextLine();
                    System.out.println(massage);
                    i++;
                    attempt++;
           }
        System.out.println();
        try{
            link.close();
            serverSocket.close();
            System.out.println("connect closing");
        }catch(IOException e){
            System.out.println("connected closing error");
        }
    }
    }
