package gui.ui;

import control.OperatorV2;
import gui.dialog.Alert;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class ModifyBookUI extends JFrame {
    OperatorV2 operatorV2=new OperatorV2();
    private JLabel bookNameLabel;
    private JTextField textField1;
    private JLabel authorLabel;
    private JTextField textField3;
    private JLabel priceLabel;
    private JTextField textField4;
    private JButton modifyButton;
    private JButton cancelButton;
    private JTable table1;
    private JPanel contentPanel;
    private JTextField textField2;
    private JLabel newBookNameLabel;

    private MainUI mainUI;

    public ModifyBookUI(MainUI mainUI){
        this.mainUI=mainUI;
        InitClass.init(ModifyBookUI.this,"更改图书");
        contentPanel =new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        bookNameLabel=InitClass.initLabel(contentPanel,"图书名：");
        textField1=InitClass.initTextField(contentPanel);
        newBookNameLabel=InitClass.initLabel(contentPanel,"新图书名：");
        textField2=InitClass.initTextField(contentPanel);
        authorLabel=InitClass.initLabel(contentPanel,"作者名：");
        textField3=InitClass.initTextField(contentPanel);
        priceLabel=InitClass.initLabel(contentPanel,"价格：");
        textField4=InitClass.initTextField(contentPanel);
        modifyButton=InitClass.initButton(contentPanel,"修改");
        cancelButton=InitClass.initButton(contentPanel,"退出");


        table1=new JTable();
        table1.setBounds(300,300,100,35);

        modifyButton.addActionListener(new ModifyAction());

        cancelButton.addActionListener(new CancelAction());
    }

    private class ModifyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //从文本框中取值
            String name=textField1.getText();
            String newName=textField2.getText();
            String author=textField3.getText();
            float price=Float.parseFloat(textField4.getText());

            if(operatorV2.isExist(name)!=true){
                Alert alert=new Alert(ModifyBookUI.this,"BookName is not exist");
                alert.setVisible(true);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                contentPanel.updateUI();
                return;
            }else {
                boolean flag=operatorV2.modifyBook(newName,author,price,name);
                if(flag==true){
                    Alert alert=new Alert(ModifyBookUI.this,"Modify Success");
                    alert.setVisible(true);
                    contentPanel.updateUI();
                }else {
                    Alert alert=new Alert(ModifyBookUI.this,"Modify Fail");
                    alert.setVisible(true);
                    contentPanel.updateUI();
                }
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
}
