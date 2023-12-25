package main;

import main.GameFrame;
import main.GamePanel;

public class Main {
    public static void main(String[] args) {
        GameFrame frame=new GameFrame();
        GamePanel panel=new GamePanel(frame);
        frame.add(panel);
    }
}