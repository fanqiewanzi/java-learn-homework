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

/**
 * @author BAZINGA
 */
public class DeleteBookUI extends JFrame {
    OperatorV2 operatorV2=new OperatorV2();
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField;
    private JButton deleteButton;
    private JTable table1;
    private JButton cancelButton;

    private MainUI mainUI;

   public DeleteBookUI(MainUI mainUI){
       this.mainUI=mainUI;
       InitClass.init(DeleteBookUI.this,"删除图书");
       contentPanel =new JPanel();
       contentPanel.setBorder(new EmptyBorder(5,5,5,5));
       setContentPane(contentPanel);
       addComponent();

       textField.setSize(50,20);

       table1.setBounds(300,300,100,35);

       deleteButton.addActionListener(new DeleteAction());

       cancelButton.addActionListener(new CancelAction());
   }

    private void addComponent(){
        contentPanel.add(label1);
        contentPanel.add(textField);
        contentPanel.add(deleteButton);
        contentPanel.add(cancelButton);
        contentPanel.add(table1);
    }

    private class DeleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=textField.getText();

            if(!operatorV2.isExist(name)){
                Alert alert=new Alert("BookName is not exist");
                alert.setVisible(true);
                textField.setText("");
                contentPanel.updateUI();
                return;
            }else {
                boolean flag=operatorV2.deleteBookByName(name);
                if(flag){
                    Alert alert=new Alert("Delete Success");
                    alert.setVisible(true);
                    contentPanel.updateUI();
                }else {
                    Alert alert=new Alert("Delete Fail");
                    alert.setVisible(true);
                    contentPanel.updateUI();
                }
            }
            ResultSet resultSet=operatorV2.printBook();
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

    private class CancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainUI.setVisible(true);
            setVisible(false);
            dispose();
        }
    }

}
