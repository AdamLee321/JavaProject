package gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adam Lee on 24/03/2015.
 */
public class ccValidation {

    private String message = null;

    public ccValidation() {
    }

    //Getter for message
    public String getMessage() {
        return message;
    }

    //Setter for message
    private void setMessage(String message) {
        this.message = message;
    }

    //to add more cc Types
    public static final int MASTERCARD = 0, VISA = 1;

    //Final message for incorrect cc number
    private static final String[] messages = {
            "Not a valid number for MasterCard.",
            "Not a valid number for Visa."};

    public boolean isCreditCardValid(String number, int type) {

        if (number.equals("")) {
            setMessage("Field cannnot be blank.");
            return false;
        }

        //Not allowing for spaces in the credit card number
        Matcher m = Pattern.compile("[^\\d\\s.-]").matcher(number); //Regex Expression

        if (m.find()) {
            setMessage("Credit card number can only contain numbers");
            return false;
        }

        setMessage(messages[type]);
        Matcher matcher = Pattern.compile("[\\s.-]").matcher(number); //Regex Expression
        number = matcher.replaceAll("");

        return validate(number, type);

    }

    // Check that cards start with proper digits for
    // selected card type and are also the right length.
    private boolean validate(String number, int type) {

        if (null == number || number.length() < 12)
            return false;


        switch (type) {
            case MASTERCARD:
                if (number.length() != 16 //Not sure on Mastercard digits need to confirm
                        || Integer.parseInt(number.substring(0, 2)) < 51
                        || Integer.parseInt(number.substring(0, 2)) > 55) {
                    return false;
                }
                break;

            case VISA:
                if ((number.length() != 13 && number.length() != 16)
                        || Integer.parseInt(number.substring(0, 1)) != 4) {
                    return false;
                }
                break;
        }

        return luhnValidate(number);

    }

    //Luhn's Algorithm
    private boolean luhnValidate(String numberString) {

        char[] charArray = numberString.toCharArray();
        int[] number = new int[charArray.length];
        int total = 0;

        for (int i = 0; i < charArray.length; i++) {
            number[i] = Character.getNumericValue(charArray[i]);
        }

        for (int i = 2 - number.length; i > -1; i -= 2) {
            number[i] *= 2;

            if (number[i] > 9)
                number[i] -= 9;
        }

        for (int i = 0; i < number.length; i++)
            total += number[i];

        if (total % 10 != 0)
            return false;

        return true;
    }

    //By following the algorithm of validating a credit card number and
    //determining the the type of the card being used, in the Sales window call the validator method,
    //call the getMessage method to receive a message if the card is invalid.
}
