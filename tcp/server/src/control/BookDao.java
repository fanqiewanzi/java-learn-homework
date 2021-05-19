package control;

import database.DBConnection;
import model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao{

    public DBConnection database=new DBConnection();

    public boolean isExist(String bookName){
        try{
            database.setSelectStatement(bookName,"",0,0);
            ResultSet resultSet= database.selectStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public boolean addBook(String name,String author,float price){
        try{
            database.insertStatement.setString(1,name);
            database.insertStatement.setString(2,author);
            database.insertStatement.setFloat(3,price);
            int num= database.insertStatement.executeUpdate();
            return num != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBookByName(String name){
        try{
            database.deleteStatement.setString(1,name);
            int num= database.deleteStatement.executeUpdate();
            return num != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBookByAuthor(String author){
        try{
            database.deleteStatement.setString(1,author);
            int num= database.deleteStatement.executeUpdate();
            return num != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyBook(String name,String newName,String author,float price){
        try{
            database.updateStatement.setString(1,newName);
            database.updateStatement.setString(2,author);
            database.updateStatement.setFloat(3,price);
            database.updateStatement.setString(4,name);
            int num= database.updateStatement.executeUpdate();
            return num != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Book> searchBookByName(String bookName){
        try{
            database.setSelectStatement(bookName,"",0,0);
            ResultSet resultSet=database.selectStatement.executeQuery();
            return resultSetParser(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Book> searchBookByAuthor(String author){
        try{
            database.setSelectStatement("",author,0,0);
            ResultSet resultSet=database.selectStatement.executeQuery();
            return resultSetParser(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Book> searchBookByPrice(float lowerPrice,float upperPrice){
        try{
            database.setSelectStatement("","",lowerPrice,upperPrice);
            ResultSet resultSet=database.selectStatement.executeQuery();
            return resultSetParser(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Book> printBook(){
        try{
            ResultSet resultSet=database.statement.executeQuery("SELECT bookId, bookName, author,price FROM book");
            return resultSetParser(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Book> resultSetParser(ResultSet resultSet){
        ArrayList<Book> books=new ArrayList<>();
        try{
            while (resultSet.next()){
                Book book=new Book(resultSet.getString("BookName"),
                        resultSet.getString("author"),
                        resultSet.getFloat("price"));
                books.add(book);
            }
            return books;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
