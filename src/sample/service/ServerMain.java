package sample.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    private static BufferedReader br=null;
    private static PrintWriter pw=null;
    private static ServerSocket ss;
    private static Socket s;
    static Scanner scanner=new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ss=new ServerSocket(5500);
            System.out.println("服务器正常启动。。。。");
            s=ss.accept();//阻塞方法
            System.out.println("连接成功"+s.getRemoteSocketAddress());
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
//            while(true){
                String string=br.readLine();
                System.out.println("Server读到："+string);
                pw.println("收到："+string);
                pw.flush();
//                if(str.equals("exit")){
//                    break;
//                }
//            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            pw.close();
            br.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
