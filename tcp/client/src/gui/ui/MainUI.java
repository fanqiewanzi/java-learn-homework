package gui.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame {
    private JButton addButton;
    private JButton deleteButton;
    private JButton modifyButton;
    private JButton searchButton;
    private JPanel contentPanel;
    private JButton cancelButton;

    public MainUI(){
        InitClass.init(MainUI.this,"图书管理");
        contentPanel=new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);

        addButton=InitClass.initButton(contentPanel,"添加图书");
        deleteButton=InitClass.initButton(contentPanel,"删除图书");
        modifyButton=InitClass.initButton(contentPanel,"修改图书");
        searchButton=InitClass.initButton(contentPanel,"查找图书");
        cancelButton=InitClass.initButton(contentPanel,"退出");

        //按钮绑定方法
        searchButton.addActionListener(new DirectAction(searchButton));
        addButton.addActionListener(new DirectAction(addButton));
        deleteButton.addActionListener(new DirectAction(deleteButton));
        modifyButton.addActionListener(new DirectAction(modifyButton));
        cancelButton.addActionListener(new DirectAction(cancelButton));


    }

    private class DirectAction implements MyActionListener{

        private JButton button;

        public DirectAction(JButton button){
            setButton(button);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame=null;
            switch (button.getText()) {
                case "添加图书" -> frame = new AddBookUI(MainUI.this);
                case "删除图书" -> frame = new DeleteBookUI(MainUI.this);
                case "修改图书" -> frame = new ModifyBookUI(MainUI.this);
                case "查找图书" -> frame = new SearchBookUI(MainUI.this);
                case "退出" -> dispose();
            }
            if(frame!=null){
                frame.setVisible(true);
                setVisible(false);
            }
        }
        @Override
        public void setButton(JButton button) {
            this.button=button;
        }
    }

    private interface MyActionListener extends ActionListener {
        void setButton(JButton button);
    }

    public static void main(String[] args) {
        MainUI mainUI=new MainUI();
        mainUI.setVisible(true);
    }

}

