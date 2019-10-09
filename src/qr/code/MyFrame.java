package qr.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel imagePanel;
    private JPanel editPanel;
    private JButton okBtn;
    private JButton clearBtn;
    private JTextField msgText;
    JLabel imageLabel;
    ImageIcon imageIcon;

    public MyFrame() throws Exception {
        this.setTitle("二维码生成器");
        this.setSize(500, 600);
        Toolkit kit = Toolkit.getDefaultToolkit();
        this.setLocation((int) (this.getWidth() / 2 - kit.getScreenSize().getWidth() / 2),
                (int) (this.getHeight() / 2 - kit.getScreenSize().getHeight() / 2));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        imagePanel = new JPanel();
        imageLabel = new JLabel();

        imagePanel.add(imageLabel);
        this.getContentPane().add(new JLabel("二维码生成器"), BorderLayout.NORTH);
        this.getContentPane().add(imagePanel, BorderLayout.CENTER);

        editPanel = new JPanel();
        msgText = new JTextField(30);
        msgText.setText("在这里输入你想显示的内容");
        okBtn = new JButton("确定");
        clearBtn = new JButton("清空");
        editPanel.add(msgText, BorderLayout.WEST);
        editPanel.add(okBtn, BorderLayout.CENTER);
        editPanel.add(clearBtn, BorderLayout.EAST);
        this.getContentPane().add(editPanel, BorderLayout.SOUTH);
        clearBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                msgText.setText("");
            }
        });
        okBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    imageLabel
                            .setIcon(new ImageIcon(new URL("http://qr.topscan.com/api.php?text=" + msgText.getText())));
                    System.out.println("http://qr.topscan.com/api.php?text=" + msgText.getText());
                } catch (MalformedURLException e1) {
                    JOptionPane.showInternalMessageDialog(MyFrame.this, "出错了", "二维码生成出错，请稍后再试！",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }

    public void display() {
        this.setVisible(true);
    }

}
