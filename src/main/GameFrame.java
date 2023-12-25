package main;

import javax.swing.*;
import java.awt.*;

/**
 * 窗体类
 */
public class GameFrame extends JFrame {
    public GameFrame(){
        setTitle("五子棋");
        setSize(620,670);
        getContentPane().setBackground(new Color(209,146,17));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
