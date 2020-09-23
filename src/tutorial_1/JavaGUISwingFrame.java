package tutorial_1;

import javax.swing.*;

public class JavaGUISwingFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
//        jFrame.setSize(250,250); // width & height
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setTitle("My First Java Frame");
//        jFrame.setLocation(100,200); // x & y coordinates
        jFrame.setBounds(100,100,500,500); // x & y coordinates and width & height
    }
 }
