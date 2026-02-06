package github.com.WellingtonMBraganca.rest_with_springboot_and_java.request.converters;

import github.com.WellingtonMBraganca.rest_with_springboot_and_java.exceptions.UnsuportedMathOperationException;

public class NumberConverter {
    public static Double stringToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsuportedMathOperationException("Use numeric values only.");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
