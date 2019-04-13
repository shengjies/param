package sample.service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
//    public static void main(String[] args) throws IOException {
//        String  host = "127.0.0.1";
//        int port =8899;
//        Socket socket = new Socket(host,port);
//        PrintWriter out = new PrintWriter(socket.getOutputStream());
//        out.print("你好......");
//        out.flush();
//        socket.close();
//    }
    private static PrintWriter pw=null;
//    private static BufferedReader br=null;
    private static Socket s;
    static Scanner scanner=new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Socket s=new Socket(InetAddress.getLocalHost(),5500);
            pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
//            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
//            while(true){
//                System.out.println("Client端请输入：");
//                String str = scanner.next();
                pw.println("Client端请输入");
                pw.flush();
//                String string=br.readLine();
//                System.out.println("Client读到："+string);
//                if(str.equals("exit")){
//                    break;
//                }
//            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
//            br.close();
            pw.close();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
