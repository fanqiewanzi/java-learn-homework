package gui.ui;

import control.OperatorV2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


/**
 * @author BAZINGA
 */
public class SearchBookUI extends JFrame{

    OperatorV2 operatorV2=new OperatorV2();
    private JPanel contentPanel;
    private JTextField textField;
    private JButton searchButton;
    private JLabel label1;
    private JTable table1;
    private JButton cancelButton;
    private MainUI mainUI;

    public SearchBookUI(MainUI mainUi){
        this.mainUI=mainUi;
        InitClass.init(SearchBookUI.this,"查找图书");
        contentPanel =new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        label1=InitClass.initLabel(contentPanel,"图书名：");
        textField=InitClass.initTextField(contentPanel);
        searchButton=InitClass.initButton(contentPanel,"查找");
        cancelButton=InitClass.initButton(contentPanel,"退出");

        table1=new JTable();

        table1.setBounds(300,300,100,35);

        searchButton.addActionListener(new SearchAction());

        cancelButton.addActionListener(new CancelAction());

    }

    private class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=textField.getText();
            ResultSet resultSet=operatorV2.searchBook(name);
            Object[][] tableData=new Object[100][4];

            if(resultSet!=null){
                InitClass.outputs(resultSet,tableData);
            }
            String []list={"id","bookName","author","price"};

            TableModel model=new DefaultTableModel(tableData,list);
            table1.setModel(model);
            table1.setEnabled(true);
            table1.setBounds(300,300,100,35);

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
            SearchBookUI.this.setVisible(false);
            dispose();
        }
    }
}
