package utils;

import model.Book;

import java.util.ArrayList;

public class Protocol {
    /*
     * 服务器端的Protocol是将返回信息转为格式字符串
     */

    public String getFndMsg(ArrayList<Book> bookList) {
        String returnStr = "";
        for (int i = 0; i < bookList.size(); i++) {
            String bookname = bookList.get(i).getBookname();
            String author = bookList.get(i).getAuthor();
            String price = Float.toString(bookList.get(i).getPrice());
            returnStr = returnStr + bookname + "," + author + "," + price + "|";
        }
        return returnStr.substring(0, returnStr.length()-1);
        // 返回字符串格式：bookname,author,price|bookname,author,price...
    }
}
