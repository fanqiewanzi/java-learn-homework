package gui.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitClass {

    public static void init(JFrame jFrame, String message) {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        jFrame.setBounds(100, 100, 500, 450);
        //设置居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setLayout(new FlowLayout());
        jFrame.setTitle(message);
        Toolkit toolkit=jFrame.getToolkit();
        Image image=toolkit.getImage("src/gui/icon/1.jpg");
        jFrame.setIconImage(image);
    }


    public static JButton initButton(JPanel contentPanel,String text){
        JButton button=new JButton(text);
        contentPanel.add(button);
        return button;
    }

    public static JTextField initTextField(JPanel contentPanel){
        JTextField textField=new JTextField();
        textField.setPreferredSize(new Dimension(100,25));
        contentPanel.add(textField);
        return textField;
    }

    public static JLabel initLabel(JPanel contentPanel,String text){
        JLabel label=new JLabel(text);
        contentPanel.add(label);
        return label;
    }

    public static JTable initTable(JPanel contentPanel,Object[][] tableData,String[] list){
        JTable table=new JTable();
        TableModel model=new DefaultTableModel(tableData,list);
        table.setModel(model);
        table.setEnabled(true);
        table.setBounds(300,300,100,35);
        //表格文字居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);
        contentPanel.add(new JScrollPane(table));
        return table;
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