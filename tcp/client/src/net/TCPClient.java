package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
    public static Socket tcpConn = null;
    public static Scanner in;
    public static OutputStream out;

    static {        //静态代码块，在类加载时被执行
        try {
            tcpConn = new Socket("127.0.0.1", 8080);
            in = new Scanner(tcpConn.getInputStream());
            out = tcpConn.getOutputStream();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String msg){
        try {
            out.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(){
        return in.nextLine();
    }

    public TCPClient() {
            try {
                Socket tcpConnection = new Socket("127.0.0.1", 8080);

                InputStream in = tcpConnection.getInputStream();
                Scanner netIn = new Scanner(in);
                OutputStream out = tcpConnection.getOutputStream();

                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("send string:");
                    String str = scanner.next();
                    out.write((str + "\n").getBytes());
                    String result = netIn.next();
                    System.out.println("return:" + result);
                    if (str.equals("bye")) {
                        break;
                    }
                }
                in.close();
                out.close();
                tcpConnection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static void close(){
        try {
            write("0\n");
            in.close();
            out.close();
            tcpConn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
