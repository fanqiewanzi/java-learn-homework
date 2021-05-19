package modle;


import contro.OperatorV2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author BAZINGA
 */

public class ManageV5 {
    public OperatorV2 operatorV2 =new OperatorV2();
    private final Scanner stringScanner=new Scanner(System.in);
    private final Scanner digitalScanner=new Scanner(System.in);
    public void bookManage(){
        try {
            while (true) {
                printInterface();
                int statue = digitalScanner.nextInt();
                switch (statue) {
                    case 1:
                        addBook();
                        printBooks();
                        break;
                    case 2:
                        deleteBookByName();
                        printBooks();
                        break;
                    case 3:
                        modifyBook();
                        printBooks();
                        break;
                    case 4:
                        searchBook();
                        break;
                    default:
                        break;
                }
                if (statue == 0) {
                    break;
                }
            }
        }finally {
            digitalScanner.close();
            stringScanner.close();
        }
    }

    private void printInterface(){
        System.out.println("Add Book-----1");
        System.out.println("Delete Book-----2");
        System.out.println("Modify Book-----3");
        System.out.println("Search Book-----4");
        System.out.println("Quit-----0");
    }

    private void addBook(){
        System.out.println("Enter the name of the book:");
        String name=stringScanner.nextLine();
        if (operatorV2.isExist(name)){
            System.out.println("The book is already exist");
            return;
        }
        System.out.println("Enter the author of the book:");
        String author=stringScanner.nextLine();
        System.out.println("Enter the price of the book:");
        float price=digitalScanner.nextFloat();
        if(operatorV2.addBook(name,author,price)){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    private void deleteBookByName(){
        System.out.println("Enter the name of the book:");
        String name=stringScanner.nextLine();
        if (!operatorV2.isExist(name)){
            System.out.println("The book is not exist");
            return;
        }
        if(operatorV2.deleteBookByName(name)){
            System.out.println("delete success");
        }else {
            System.out.println("delete fail");
        }
    }

    private void modifyBook(){
        System.out.println("Enter the name of the book:");
        String name=stringScanner.nextLine();
        if (!operatorV2.isExist(name)){
            System.out.println("The book is not exist");
            return;
        }
        System.out.println("Enter the new name of the book:");
        String newName=stringScanner.nextLine();
        System.out.println("Enter the author of the book:");
        String author=stringScanner.nextLine();
        System.out.println("Enter the price of the book:");
        float price=digitalScanner.nextFloat();
        if(operatorV2.modifyBook(newName,author,price,name)){
            System.out.println("update success");
        }else {
            System.out.println("update fail");
        }
    }
    private void searchBook(){
        System.out.println("Enter the name of the book:");
        String name=stringScanner.nextLine();
        if (!operatorV2.isExist(name)){
            System.out.println("The book is not exist");
            return;
        }
        ResultSet resultSet= operatorV2.searchBook(name);
        if(resultSet!=null) {
            try {
                while (resultSet.next()) {
                    // 通过字段检索
                    int id = resultSet.getInt("bookId");
                    String bookName = resultSet.getString("bookName");
                    String author = resultSet.getString("author");
                    float price = resultSet.getFloat("price");
                    // 输出数据
                    System.out.print("ID: " + id);
                    System.out.print(", 图书名: " + bookName);
                    System.out.print(", 作者: " + author);
                    System.out.println(",价格: " + price);
                    System.out.print("\n");
                }
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void printBooks(){
        ResultSet resultSet= operatorV2.printBook();
        if (resultSet!=null) {
            try {
                while (resultSet.next()) {
                    // 通过字段检索
                    int id = resultSet.getInt("bookId");
                    String bookName = resultSet.getString("bookName");
                    String author = resultSet.getString("author");
                    float price = resultSet.getFloat("price");
                    // 输出数据
                    System.out.print("ID: " + id);
                    System.out.print(", 图书名: " + bookName);
                    System.out.print(", 作者: " + author);
                    System.out.println(",价格: " + price);
                    System.out.print("\n");
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
