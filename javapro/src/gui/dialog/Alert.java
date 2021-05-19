package gui.dialog;

import gui.ui.InitClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Alert extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel messageLabel;

    public Alert(JFrame frame,String message) {
        setBounds(100,100,100,100);
        setLocationRelativeTo(frame);
        setResizable(false);
        contentPane=new JPanel();
        setContentPane(contentPane);
        messageLabel=InitClass.initLabel(contentPane,"提示");
        buttonOK= InitClass.initButton(contentPane,"OK");
        getRootPane().setDefaultButton(buttonOK);
        //设置标题及窗口居中
        setTitle("提示");
        setLocationRelativeTo(null);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        messageLabel.setText(message);

        setVisible(true);
    }

    private void onOK() {
        dispose();
    }
}
