package gui.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author BAZINGA
 */
public class MainUI extends JFrame{
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

        //按钮绑定方法
        searchButton.addActionListener(new DirectAction(searchButton));
        addButton.addActionListener(new DirectAction(addButton));
        deleteButton.addActionListener(new DirectAction(deleteButton));
        modifyButton.addActionListener(new DirectAction(modifyButton));
        cancelButton.addActionListener(new DirectAction(cancelButton));
        addComponent();
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
                case "Add" -> frame = new AddBookUI(MainUI.this);
                case "Delete" -> frame = new DeleteBookUI(MainUI.this);
                case "Modify" -> frame = new ModifyBookUI(MainUI.this);
                case "Search" -> frame = new SearchBookUI(MainUI.this);
                case "Cancel" -> dispose();
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

    private interface MyActionListener extends ActionListener{
         void setButton(JButton button);
    }

    private void addComponent(){
        contentPanel.add(addButton);
        contentPanel.add(deleteButton);
        contentPanel.add(modifyButton);
        contentPanel.add(searchButton);
        contentPanel.add(cancelButton);
    }

    public static void main(String[] args) {
        MainUI mainUI=new MainUI();
        mainUI.setVisible(true);
    }

}
