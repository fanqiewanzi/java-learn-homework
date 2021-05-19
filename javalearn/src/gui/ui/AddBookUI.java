package gui.ui;

import contro.OperatorV2;
import gui.dialog.Alert;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class AddBookUI extends JFrame{
    OperatorV2 operatorV2=new OperatorV2();
    private JLabel bookNameLabel;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JTable table1;
    private JButton cancelButton;
    private JPanel contentPanel;
    private JLabel priceLabel;
    private JLabel authorLabel;
    private MainUI mainUI;

    public AddBookUI(MainUI mainUi){
        this.mainUI=mainUi;
        InitClass.init(AddBookUI.this,"添加图书");
        contentPanel =new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        addComponent();

        table1.setBounds(300,300,100,35);

        addButton.addActionListener(new AddAction());

        cancelButton.addActionListener(new CancelAction());
    }

    private class AddAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //从文本框中取值
            String name=textField.getText();
            String author=textField1.getText();
            float price=Float.parseFloat(textField2.getText());

                if(operatorV2.isExist(name)){
                Alert alert=new Alert("BookName is already exist");
                alert.setVisible(true);
                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                contentPanel.updateUI();
                return;
            }else {
                boolean flag=operatorV2.addBook(name,author,price);
                if(flag){
                    ResultSet resultSet=operatorV2.printBook();
                    Object[][] tableData=new Object[100][4];
                    if(resultSet!=null){
                        InitClass.outputs(resultSet,tableData);
                    }
                    String []list={"id","bookName","author","price"};
                    TableModel model=new DefaultTableModel(tableData,list);
                    table1.setModel(model);
                    table1.setEnabled(true);
                    table1.setBounds(300,300,100,35);
                }
            }

            //表格文字居中
            DefaultTableCellRenderer r = new DefaultTableCellRenderer();
            r.setHorizontalAlignment(JLabel.CENTER);
            table1.setDefaultRenderer(Object.class,r);

            contentPanel.add(new JScrollPane(table1));
            contentPanel.updateUI();
        }
    }

    private class CancelAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainUI.setVisible(true);
            setVisible(false);
            dispose();
        }
    }

    //添加组件
    private void addComponent(){
        contentPanel.add(bookNameLabel);
        contentPanel.add(textField);
        contentPanel.add(authorLabel);
        contentPanel.add(textField1);
        contentPanel.add(priceLabel);
        contentPanel.add(textField2);
        contentPanel.add(addButton);
        contentPanel.add(cancelButton);
        contentPanel.add(table1);
    }

}
