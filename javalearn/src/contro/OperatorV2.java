package contro;

import sql.DataBaseV2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author BAZINGA
 */
public class OperatorV2 {

    public boolean isExist(String name){
        Connection connection=DataBaseV2.getConnection();
        Statement statement=null;
        try{
            statement=connection.createStatement();
            String sql="SELECT bookId, bookName, author,price FROM book Where bookName='"+name+"'";
            ResultSet resultSet= statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DataBaseV2.close(connection,statement);
        }
        return false;
    }


    public boolean addBook(String name,String author,float price){
        Connection connection=DataBaseV2.getConnection();
        Statement statement=null;
        try{
            statement=connection.createStatement();
            String sql="INSERT INTO book(bookName,author,price) values('"+name+"','"+author+"',"+price+")";
            int num= statement.executeUpdate(sql);
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            DataBaseV2.close(connection,statement);
        }
    }

    public boolean deleteBookByName(String name){
        Connection connection=DataBaseV2.getConnection();
        Statement statement=null;
        try{
            statement=connection.createStatement();
            String sql="DELETE FROM book WHERE bookName='"+name+"'";
            int num= statement.executeUpdate(sql);
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            DataBaseV2.close(connection,statement);
        }
    }


    public boolean modifyBook(String newName,String author,float price,String name){
        Connection connection=DataBaseV2.getConnection();
        Statement statement=null;
        try{
            statement=connection.createStatement();
            String sql="UPDATE book SET bookName='"+newName+"',author='"+author+"',price="+price+" WHERE bookName='"+name+"'";
            int num= statement.executeUpdate(sql);
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            DataBaseV2.close(connection,statement);
        }
    }

    public ResultSet searchBook(String name){
        Connection connection=DataBaseV2.getConnection();
        Statement statement=null;
        try{
            statement=connection.createStatement();
            String sql="SELECT bookId, bookName, author,price FROM book Where bookName='"+name+"'";
            return statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet printBook(){
        Connection connection=DataBaseV2.getConnection();
        Statement statement=null;
        try{
            statement=connection.createStatement();
            return statement.executeQuery("SELECT bookId, bookName, author,price FROM book LIMIT 100 ");
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
