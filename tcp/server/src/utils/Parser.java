package utils;

public class Parser {

    public String[] MyParser(String receiveStr){
        String splt[] = receiveStr.split(":");
        String op = splt[0];
        String attr = splt[1];
        switch(op){
            case "isExist":{
                String attrs[]=attr.split(",");
                String name=attrs[0];
                String[] parsedStr={"isExist",name};
                return parsedStr;
            }
            case "addBook": {	//addbook:bookname, author, price
                String attrs[]=attr.split(",");
                String bookName = attrs[0];
                String author = attrs[1];
                String price = attrs[2];
                String[] parsedStr = {"addBook",bookName,author,price};
                return parsedStr;
            }
            case "deleteByBookName":{
                String attrs[]=attr.split(",");
                String bookName = attrs[0];
                String[] parsedStr = {"deleteByBookName",bookName};
                return parsedStr;
            }
            case "deleteByAuthor":{
                String attrs[]=attr.split(",");
                String author = attrs[0];
                String[] parsedStr = {"deleteByAuthor",author};
                return parsedStr;
            }
            case "findByBookName":{
                String attrs[]=attr.split(",");
                String bookName = attrs[0];
                String[] parsedStr = {"findByBookName",bookName};
                return parsedStr;
            }
            case "findByAuthor":{
                String attrs[]=attr.split(",");
                String author  = attrs[0];
                String[] parsedStr = {"findByAuthor",author};
                return parsedStr;
            }
            case "findByPrice":{
                String attrs[]=attr.split(",");
                String lowBound = attrs[0];
                String upBound = attrs[1];
                String[] parsedStr = {"findByPrice",lowBound,upBound};
                return parsedStr;
            }
            case "alterBook":{
                String attrs[]=attr.split(",");
                String cursorBookName = attrs[0];
                String bookName = attrs[1];
                String author = attrs[2];
                String price = attrs[3];
                String[] parsedStr = {"alterBook",cursorBookName,bookName,author,price};
                return parsedStr;
            }
            case "printAllBook":{
                String[] parsedStr = {"printAllBook"};
                return parsedStr;
            }
            default: return null;
        }
    }
}
