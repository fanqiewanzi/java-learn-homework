package control;


import sql.DataBaseV2;



import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author BAZINGA
 */
public class OperatorV2 {
    public DataBaseV2 dataBaseV1 =new DataBaseV2();

    public boolean isExist(String name){
        try{
            dataBaseV1.selectStatement.setString(1,name);
            ResultSet resultSet= dataBaseV1.selectStatement.executeQuery();
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
            dataBaseV1.insertStatement.setString(1,name);
            dataBaseV1.insertStatement.setString(2,author);
            dataBaseV1.insertStatement.setFloat(3,price);
            int num= dataBaseV1.insertStatement.executeUpdate();
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBookByName(String name){
        try{
            dataBaseV1.deleteStatement.setString(1,name);
            int num= dataBaseV1.deleteStatement.executeUpdate();
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBookByAuthor(String author){
        try{
            dataBaseV1.deleteStatement.setString(1,author);
            int num= dataBaseV1.deleteStatement.executeUpdate();
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyBook(String newName,String author,float price,String name){
        try{
            dataBaseV1.updateStatement.setString(1,newName);
            dataBaseV1.updateStatement.setString(2,author);
            dataBaseV1.updateStatement.setFloat(3,price);
            dataBaseV1.updateStatement.setString(4,name);
            int num= dataBaseV1.updateStatement.executeUpdate();
            if(num!=0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet searchBook(String name){
        try{
            dataBaseV1.selectStatement.setString(1,name);
            return dataBaseV1.selectStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet printBook(){
        try{
            return dataBaseV1.statement.executeQuery("SELECT bookId, bookName, author,price FROM book");
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
