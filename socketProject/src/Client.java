
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
public class Client {
    private static int port =1234;
    private static int port2 =1235;
    private static int port3 =1236;
    private static Socket link2 = null;
    private static Socket link3 = null;
    public static void main(String[] args) throws IOException {

        ClientAccess();
    }
    private static  void ClientAccess() throws SocketException, IOException  {
        Socket link = null;
        link = new Socket("localhost",port);
        link2= new Socket("localhost",port2);
        link3= new Socket("localhost",port3);
        Scanner input[] = {new Scanner(link.getInputStream()),new Scanner(link2.getInputStream()),new Scanner(link3.getInputStream())};
        PrintWriter output[] = {new PrintWriter(link.getOutputStream(),true),new PrintWriter(link2.getOutputStream(),true)
        ,new PrintWriter(link3.getOutputStream(),true)};    
        int i = 0;
        Scanner user = new Scanner(System.in);
        String packag=" PCK ";
        String response;
        String massage = " ";
        long startTime = System.nanoTime();
        int attempt =0;
                 while(!massage.equalsIgnoreCase("close")){
                     if(i > 2 ){ i = 0;};
                    System.out.println("Enter massage to server: ");
                    massage = user.nextLine();
                    output[i].println(massage);
                    output[i].flush();
                    output[i].println(packag+attempt);
                    output[i].flush();
                    if(massage.equalsIgnoreCase("CLOSE")){
                        break;
                    }
                    response = input[i].nextLine();
                    System.out.println(response);
                    link.setSoTimeout(10000);
                    attempt++;
                    i++;
                    
                } 
        long endTime = System.nanoTime();
        System.out.println("Time:"+(endTime-startTime));
        
        try{
            link.close();
            System.out.println("connect closing");
        }catch(IOException e){
            System.out.println("error to close connected");
        }
    }}
