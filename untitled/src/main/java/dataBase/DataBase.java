package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DataBase {

    private static final String USER_NAME="root";
    private static final String PASSWORD="123456";
    private static final String URL="jdbc:mysql://localhost:3306/testrace?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private String sql1="SELECT id, name, xpath FROM scsz";
    private String sql2="SELECT * FROM scsz_test";
    private String sql3="SELECT COUNT(*) FROM information_schema.columns WHERE table_schema='testrace' AND TABLE_NAME ='scsz_test'";
    public Connection connection;
    public Statement statement;
    public PreparedStatement selectStatement1;
    public PreparedStatement selectStatement2;
    public PreparedStatement selectStatement3;
    public DataBase(){
        try {
            connection=getConnection();
            statement=connection.createStatement();
            selectStatement1=connection.prepareStatement(sql1);
            selectStatement2=connection.prepareStatement(sql2);
            selectStatement3=connection.prepareStatement(sql3);
            System.out.println("连接成功");
        }catch (Exception e){
            System.out.println("连接失败");
        }
    }

    public void close(){
        try{
            statement.close();
            selectStatement1.close();
            selectStatement2.close();
            selectStatement3.close();
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
