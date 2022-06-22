package net.htlgkr.teachablemachine.scaler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageScaler {
    public static void main(String[] args) throws IOException {

        ImageScaler m = new ImageScaler();
        m.scaleImage();
    }
        public void scaleImage() throws IOException {
            BufferedImage bufferedImage = ImageIO.read(new File("/Users/paula/Desktop/Teachable-Machine/Scaler/Teachablemachinescaler/pictures/monkey.jpeg"));

            Image image = bufferedImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT);

        ImageIcon icon = new ImageIcon(image);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);

        JLabel jLabel = new JLabel();
        jLabel.setIcon(icon);
        frame.add(jLabel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    }
