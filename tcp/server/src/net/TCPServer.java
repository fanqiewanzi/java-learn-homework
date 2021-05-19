package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
    public TCPServer(){
        try{
            ServerSocket server=new ServerSocket(8080);
            while(true) {
                System.out.println("Listening:8080");
                Socket tcpConnection = server.accept();
                Thread th=new Thread(new ServerThread(tcpConnection));
                th.start();
                }
            }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new TCPServer();
    }
}
