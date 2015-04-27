package gui;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 01/04/2015)
*/

import javax.swing.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidator {

    // check if text field is empty
    public static boolean isEmptyField(String field) {
        return (field.isEmpty());
    }

    // check if password field is empty
    public static boolean isEmptyPassField(char[] pw) {
        return (pw.length == 0);
    }

    // validate email
    public static boolean isValidEmail(String email) {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return (matcher.matches());
    } // http://howtodoinjava.com/2014/11/11/java-regex-validate-email-address/

    // check if passed in variable is a number
    public static boolean isNumber(String string) {
        try {
            Long.parseLong(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // check if passed in variable is a double
    public static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // check
    public static boolean isCorrectLength(String string, int length) {
        return (string.length() == length);
    }

    // check if bytes[] matches file
    public static boolean bytesEqualFile(byte[] bytesIn, File f) {

        File outputFile = new File("src/res/temp0");

        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            outputStream.write(bytesIn);  //write the bytes and you're done.

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Image Error");
        }

        return (outputFile == f);
    }


    // Compare if two files are identical
    // Taken from - http://stackoverflow.com/questions/7355638/java-comparing-bytes-in-files-that-have-weird-contents
    public static boolean equalFiles(File f1, File f2) {

        boolean equals = false;

        try{
            byte[] b1 = getBytesFromFile(f1);
            byte[] b2 = getBytesFromFile(f2);

            equals = true;

            if (b1.length != b2.length) return false;
            for (int i = 0; i < b1.length; i++) {
                if (b1[i] != b2[i]) return false;
            }
        } catch (IOException io){
            JOptionPane.showMessageDialog(null,"Problem with file comparison");
        }
        return equals;
    }

    // returns the index (0 indexed) of the first difference, or -1 if identical
    // fails for files 2G or more due to limitations of "int"... use long if needed
    static int firstDiffBetween(File f1, File f2) {

        int index = 0;

        try{
            byte[] b1 = getBytesFromFile(f1);
            byte[] b2 = getBytesFromFile(f2);

            int shortest = b1.length;
            if (b2.length < shortest) shortest = b2.length;
            for (int i = 0; i < shortest; i++) {
                if (b1[i] != b2[i])
                    index = i;
            }
            index = -1;
        } catch (IOException io){
            JOptionPane.showMessageDialog(null,"Problem with file comparison");
        }
        return index;
    }

    // Returns the contents of the file in a byte array.
    // shamelessly stolen from http://www.exampledepot.com/egs/java.io/file2bytearray.html
    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
