package net.htlgkr.teachablemachine.scaler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Paths;
import java.util.Objects;

public class ImageScaler {
    public static void main(String[] args) throws IOException {
        ImageScaler m = new ImageScaler();
        System.out.println("start");
        int i = 0;

        m.scaleImages(Objects.requireNonNull(new File("pictures/Gorilla").listFiles()));



    }
    public void scaleImage(File f) throws IOException {

            BufferedImage bufferedImage = ImageIO.read(f);
            if(bufferedImage != null) {
                Image image = bufferedImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT);

                ImageIcon icon = new ImageIcon(image);
                JFrame frame = new JFrame();
                frame.setLayout(new FlowLayout());
                frame.setSize(500, 500);

                JLabel jLabel = new JLabel();
                jLabel.setIcon(icon);
                frame.add(jLabel);
                System.out.println("Image scaled 1");

                try {
                    BufferedImage outputImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
                    outputImage.getGraphics().drawImage(image, 0, 0, null);
                    new File(f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf("/")) + "-scale//").mkdirs();
                    File outputfile = new File(f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf("/")) + "-scale/" + f.getName());
                    ImageIO.write(outputImage, "jpg", outputfile);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }

    public void scaleImages(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                scaleImages(Objects.requireNonNull(file.listFiles())); // Calls same method again.
            } else {
                try {
                    scaleImage(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
