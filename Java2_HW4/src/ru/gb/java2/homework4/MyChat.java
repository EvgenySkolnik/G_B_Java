package ru.gb.java2.homework4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class MyChat extends JFrame {

    JPanel jpanN = new JPanel(new GridLayout());
    JPanel jpanS = new JPanel(new GridLayout());

    JButton jbExit = new JButton("Enter");
    JTextArea jtar = new JTextArea();
    JScrollPane jspane = new JScrollPane(jtar);
    JTextField jtfld = new JTextField();

    PrintWriter pw = new PrintWriter(new FileWriter("1.txt"));

    MyChat() throws IOException {
        super("My chat");
        setSize(300, 400);
        setMinimumSize(new Dimension(300, 400));

        jtar.setLineWrap(true);
        jtar.setEditable(false);

        //ACTIONS
        jbExit.addActionListener(e -> {
            sendMessage();
        });
        jtfld.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });

        jpanN.add(jspane);
        jpanS.add(jtfld);
        jpanS.add(jbExit);

        add(jpanN);
        add("South", jpanS);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //SEND MESSAGE & WRITE TO FILE
    void sendMessage() {
        String out = jtfld.getText();
        jtar.append( "- " + out + "\n");
        pw.append( "- " + out + "\n");
        pw.flush();
        jtfld.setText("");
        jtfld.grabFocus();
    }

}

