package control;


import model.Book;
import utils.Parser;
import utils.Protocol;

import java.util.ArrayList;

public class Operator {

    BookDao bookDao=new BookDao();

    public String doOp(String receiveStr){
        Parser parser=new Parser();
        String[] parsedStr = parser.MyParser(receiveStr);
        String op = parsedStr[0];
        boolean isSuccess = false;
        switch (op) {
            case "isExist":{
                if(bookDao.isExist(parsedStr[1])){
                    return "true";
                }else {
                    return "false";
                }
            }
            case "addBook": { // addbook:bookname, author, price
                isSuccess = bookDao.addBook(parsedStr[1], parsedStr[2], Float.parseFloat(parsedStr[3]));
                return String.valueOf(isSuccess);
            }
            case "deleteByBookName": { // delbybookname:bookname
                isSuccess = bookDao.deleteBookByName(parsedStr[1]);
                return String.valueOf(isSuccess);
            }
            case "deleteByAuthor": {
                isSuccess = bookDao.deleteBookByAuthor(parsedStr[1]);
                return String.valueOf(isSuccess);
            }
            case "findByBookName": {
                ArrayList<Book> bookList = bookDao.searchBookByName(parsedStr[1]);
                Protocol protocol = new Protocol();
                String returnStr = protocol.getFndMsg(bookList);
                System.out.println("returnStr: " + returnStr);
                return returnStr;
            }
            case "findByAuthor": {
                ArrayList<Book> bookList = bookDao.searchBookByAuthor(parsedStr[1]);
                Protocol protocol = new Protocol();
                String returnStr = protocol.getFndMsg(bookList);
                return returnStr;
            }
            case "findByPrice": {
                ArrayList<Book> bookList = bookDao.searchBookByPrice(Float.parseFloat(parsedStr[1]), Float.parseFloat(parsedStr[2]));
                Protocol protocol = new Protocol();
                String returnStr = protocol.getFndMsg(bookList);
                return returnStr;
            }
            case "alterBook": {
                isSuccess = bookDao.modifyBook(parsedStr[1], parsedStr[2], parsedStr[3], Float.parseFloat(parsedStr[4]));
                return String.valueOf(isSuccess);
            }
            case "printAllBook": {
                ArrayList<Book> bookList = bookDao.printBook();
                Protocol protocol = new Protocol();
                String returnStr = protocol.getFndMsg(bookList);
                return returnStr;
            }
            default:
                return "false";
        }

    }

}
