package control;


import net.TCPClient;
import utils.Parser;
import utils.Protocol;

public class Operator {
    
    public boolean isExist(String bookName){
        String msg=Protocol.isBookNameExist(bookName);
        TCPClient.write(msg);
        String result=TCPClient.read();
        System.out.println(result);
        return Parser.getIsSuccess(result);
    }
    
    public boolean addBook(String bookName, String author, float price) {
        String msg = Protocol.getAddBookMsg(bookName, author, price); // 打包查询语句
        TCPClient.write(msg); // 发送信息给服务器，服务器处理请求
        String returnStr = TCPClient.read();
        System.out.println(returnStr);
        return Parser.getIsSuccess(returnStr);
    }

    public boolean delBookByBookName(String bookName) {
        String msg = Protocol.getDelByBookNameMsg(bookName);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.getIsSuccess(returnStr);
    }

    public boolean delBookByAuthor(String author) {
        String msg = Protocol.getDelByAuthorMsg(author);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.getIsSuccess(returnStr);
    }

    public boolean delBookByPrice(float lowBound, float upBound) {
        String msg = Protocol.getDelByPriceMsg(lowBound, upBound);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.getIsSuccess(returnStr);
    }

    public String[][] fndByBookName(String bookName) {
        String msg = Protocol.getFndByBookNameMsg(bookName);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.fndBookParser(returnStr);
    }

    public String[][] fndByAuthor(String author) {
        String msg = Protocol.getFndByAuthorMsg(author);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.fndBookParser(returnStr);
    }

    public String[][] fndByPrice(float lowerPrice, float upperPrice) {
        String msg = Protocol.getFndByPriceMsg(lowerPrice,upperPrice);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.fndBookParser(returnStr);
    }

    public boolean altBook(String bookName, String newBookName, String newAuthor, float newPrice) {
        String msg = Protocol.getAltBookMsg(bookName,newBookName,newAuthor,newPrice);
        TCPClient.write(msg);
        String returnStr = TCPClient.read();
        return Parser.getIsSuccess(returnStr);
    }

    public String[][] prtAllBook() {
        String msg = Protocol.getPrtAllBookMsg();
        TCPClient.write(msg);
        System.out.println("msg:" + msg);
        String returnStr = TCPClient.read();
        System.out.println("returnStr:" + returnStr);
        return Parser.fndBookParser(returnStr);
    }
}
