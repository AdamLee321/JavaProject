package gui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * David Lawlor X00107563
 * Date 30/03/2015
 * hashPassword method credit to mkyong (http://www.mkyong.com/java/java-md5-hashing-example/)
 */

public class PasswordGenerator {

    public static String generatePassword() {
        Random r = new Random();
        String password = "";
        char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        for (int i = 0; i < 8; i++) {
            int x = r.nextInt(3);
            if (x == 0) {
                password += lower[r.nextInt(26)];
            } else if (x == 1) {
                password += upper[r.nextInt(26)];
            } else if (x == 2) {
                password += Integer.toString(nums[r.nextInt(10)]);
            }

        }
        return password;
    }

    public static String generatePassword(int length) {
        Random r = new Random();
        String password = "";
        char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        for (int i = 0; i < length; i++) {
            int x = r.nextInt(3);
            if (x == 0) {
                password += lower[r.nextInt(26)];
            } else if (x == 1) {
                password += upper[r.nextInt(26)];
            } else if (x == 2) {
                password += Integer.toString(nums[r.nextInt(10)]);
            }

        }
        return password;
    }

    public static String hashPassword(String password){
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
        }catch(NoSuchAlgorithmException nsa){
            System.out.println("The algorithm does not exist");
        }
        return sb.toString();
    }
}
//5f4dcc3b5aa765d61d8327deb882cf99 output from method
//5f4dcc3b5aa765d61d8327deb882cf99 generated from site below
//to verify that it works http://www.danstools.com/md5-hash-generator/
