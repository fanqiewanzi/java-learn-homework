package sql;

import java.sql.*;


public class DataBaseV2 {
    private final String USER_NAME="root";
    private final String PASSWORD="123456";
    private final String URL="jdbc:mysql://localhost:3306/bookmanage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private String sql1="SELECT bookId, bookName, author,price FROM book Where bookName=?";
    private String sql2="INSERT INTO book(bookName,author,price) values(?,?,?)";
    private String sql3="DELETE FROM book WHERE bookName=?";
    private String sql4="UPDATE book SET bookName=?,author=?,price=? WHERE bookName=?";
    public Connection connection;
    public Statement statement;
    public PreparedStatement selectStatement;
    public PreparedStatement insertStatement;
    public PreparedStatement deleteStatement;
    public PreparedStatement updateStatement;
    public DataBaseV2(){
        try {
            connection=getConnection();
            statement=connection.createStatement();
            selectStatement=connection.prepareStatement(sql1);
            insertStatement=connection.prepareStatement(sql2);
            deleteStatement=connection.prepareStatement(sql3);
            updateStatement=connection.prepareStatement(sql4);
            System.out.println("连接成功");
        }catch (Exception e){
            System.out.println("连接失败");
        }
    }

    public void close(){
        try{
            statement.close();
            selectStatement.close();
            updateStatement.close();
            insertStatement.close();
            deleteStatement.close();
            closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }

    public void closeConnection(Connection connection) throws Exception{
        if(connection!=null){
            connection.close();
        }
    }
}
