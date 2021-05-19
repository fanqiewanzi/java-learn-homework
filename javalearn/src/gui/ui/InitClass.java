package gui.ui;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitClass {

    public static void init(JFrame jFrame,String message) {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        jFrame.setBounds(100, 100, 500, 450);
        //设置居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle(message);
    }

    public static void outputs(ResultSet resultSet, Object[][] tableData) {
        if (resultSet != null) {
            try {
                for (int i = 0; resultSet.next(); i++) {
                    tableData[i][0] = resultSet.getInt("bookId");
                    tableData[i][1] = resultSet.getString("bookName");
                    tableData[i][2] = resultSet.getString("author");
                    tableData[i][3] = resultSet.getFloat("price");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
