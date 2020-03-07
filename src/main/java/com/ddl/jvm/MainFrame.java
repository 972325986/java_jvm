package com.ddl.jvm;

import com.ddl.jvm.parse.Args;
import com.ddl.jvm.parse.ParserUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description 主面板
 * @author: dengdl
 * @create: 2020-03-07 13:24
 **/
class MainFrame extends JFrame {
    MainFrame() {
        this.setSize(500, 400);
        this.setTitle("start jvm");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel();
        jPanel.setVisible(true);
        jPanel.setSize(500, 400);
        jPanel.setLayout(new FlowLayout());
        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setPreferredSize(new Dimension(400, 300));
        jPanel.add(jTextArea, BorderLayout.CENTER);
        JButton startButton = new JButton("start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = jTextArea.getText();
                ParserUtil.parse(Args.parse(command));
            }
        });
        jPanel.add(startButton, BorderLayout.SOUTH);
        this.setContentPane(jPanel);

    }
}
