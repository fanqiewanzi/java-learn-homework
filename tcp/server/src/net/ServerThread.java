package net;

import control.Operator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {

    Socket tcpConnection;

    public ServerThread(Socket tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void run() {
       try{
           handler();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    private void handler() throws Exception{
        System.out.println("accept IP:" + tcpConnection.getInetAddress() + "\tport:" + tcpConnection.getPort());
        InputStream in = tcpConnection.getInputStream();
        BufferedReader netIn = new BufferedReader(new InputStreamReader(in));
        OutputStream out = tcpConnection.getOutputStream();

        while (true) {
            String receiveStr = netIn.readLine();
            System.out.println("收到客户端数据：" + receiveStr);
            if (receiveStr.equals("0"))
                break;
            Operator operator = new Operator();
            String returnStr = operator.doOp(receiveStr);
            out.write((returnStr + "\n").getBytes());
        }
            in.close();
            out.close();
            tcpConnection.close();
    }

}
