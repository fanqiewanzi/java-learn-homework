package gui.ui;

import contro.OperatorV2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
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
        addComponent();

        textField.setSize(50,20);

        table1.setBounds(300,300,100,35);

        searchButton.addActionListener(new SearchAction());

        cancelButton.addActionListener(new CancelAction());

    }

    private class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=textField.getText();
            ResultSet resultSet=operatorV2.searchBook(name);
            Object[][] tableData=new Object[90][4];

            if(resultSet!=null){
                InitClass.outputs(resultSet,tableData);
            }
            String []list={"id","bookName","author","price"};

            TableModel model=new DefaultTableModel(tableData,list);
            table1.setModel(model);
            table1.setEnabled(true);
            table1.setBounds(300,300,100,35);

            DefaultTableCellRenderer r = new DefaultTableCellRenderer(); //cell居中
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

    private void addComponent(){
        contentPanel.add(label1);
        contentPanel.add(textField);
        contentPanel.add(searchButton);
        contentPanel.add(cancelButton);
        contentPanel.add(table1);
    }

}
