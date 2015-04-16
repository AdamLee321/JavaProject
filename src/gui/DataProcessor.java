package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 03/04/2015)
*/

public class DataProcessor {

    // Image Scaler - Takes an image in File format, sets widths and height and returns it scaled
    public static Image fitImageFile(File fileIn, int widthIn, int heightIn) throws IOException {

        BufferedImage img = ImageIO.read(fileIn);
        Image scaled = img.getScaledInstance(widthIn, heightIn, Image.SCALE_SMOOTH);
        return scaled;
    }

    // Image Scaler - Takes an image in byte format, sets widths and height and returns it scaled
    public static Image fitImageByte(byte[] image, int widthIn, int heightIn) throws IOException {

        ByteArrayInputStream in = new ByteArrayInputStream(image);
        BufferedImage img = ImageIO.read(in);
        Image scaled = img.getScaledInstance(widthIn, heightIn, Image.SCALE_SMOOTH);
        return scaled;
    }

    // Image Scaler - Takes an image file in String format, sets widths and height and returns it scaled
    public static Image fitImageString(String imgIn, int widthIn, int heightIn) throws IOException {

        File tempFile = new File(imgIn);

        BufferedImage img = ImageIO.read(tempFile);
        Image scaled = img.getScaledInstance(widthIn, heightIn, Image.SCALE_SMOOTH);
        return scaled;
    }

    // convert byte array to File
    public static File byteToFile(byte[] bytesIn)throws IOException {

        File outputFile = new File("src/res/temp");

        try ( FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            outputStream.write(bytesIn);  //write the bytes and your done.

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Image Error");
        }
        return outputFile;
    }

    // Image Filter - Used with JFileChooser to filter out all the non image files from the view
    public final static FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
    public final static FileNameExtensionFilter logFilter = new FileNameExtensionFilter("Log files", "log");
}
