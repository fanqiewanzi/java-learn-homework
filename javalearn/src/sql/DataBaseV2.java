package sql;

import java.sql.*;


public class DataBaseV2 {
    private static final String USER_NAME="root";
    private static final String PASSWORD="123456";
    private static final String URL="jdbc:mysql://localhost:3306/bookmanage?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Connection connection,Statement statement){
        try{
            statement.close();
            closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet){
        try{
            resultSet.close();
            statement.close();
            closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        try{
            Connection connection=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection) throws Exception{
        if(connection!=null){
            connection.close();
        }
    }

}
