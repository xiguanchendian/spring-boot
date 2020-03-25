package com.xgcd.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo extends JFrame {

    public SwingDemo() {
        JPanel jp = new JPanel();
        this.setContentPane(jp);
        jp.setLayout(new GridLayout(2, 2));

        JLabel packagebl = new JLabel("包名（小写）：");
        final JTextField packagefld = new JTextField();

        // 确定按钮
        JButton confirmbtn = new JButton("生成");

        JButton extbtn = new JButton("退出");
        extbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "加密成功！点击复制按钮拷贝密文！");
            }
        });

        jp.add(packagebl);
        jp.add(packagefld);

        // 确定、退出按钮
        jp.add(confirmbtn);
        jp.add(extbtn);

        this.setTitle("测试");
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.setSize(new Dimension(600, 400));
        this.setResizable(false);
        this.setLocationRelativeTo(this.getOwner());
    }

    public static void main(String[] args) {
        new SwingDemo();
    }
}
