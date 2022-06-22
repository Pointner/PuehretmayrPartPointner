package net.htlgkr.teachablemachine.scaler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImageScaler {
    public static void main(String[] args) throws IOException {
        ImageScaler m = new ImageScaler();
        System.out.println("start");

        File[] filesfolder1 = new File("/Users/paula/Desktop/Teachable-Machine/Scaler/Teachablemachinescaler/pictures/scaledfolder1").listFiles();
        for (File file : filesfolder1) {
            if (file.isDirectory())
                for (File f : file.listFiles()) {

                    System.out.println("Image found");
                    Image imagefolder1 = m.scaleImage(f);
                    try {

                        File outputfile = new File("image.jpg");
                        ImageIO.write((BufferedImage)imagefolder1, "jpg", outputfile);
                    } catch(IOException e) {

                    }

                }
        }




    }
        public Image scaleImage(File f) throws IOException {
            BufferedImage bufferedImage = ImageIO.read(f);

            Image image = bufferedImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT);

        ImageIcon icon = new ImageIcon(image);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);

        JLabel jLabel = new JLabel();
        jLabel.setIcon(icon);
        frame.add(jLabel);
            System.out.println("Image scaled 1");

        return image;


    }



    }
