package genericfunctions;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericUtil {
    public static String extractContentFromSquareBracket(String input) {
        Pattern pattern = Pattern.compile("\\[(.*?)]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String content = matcher.group(1);
            if (content.isEmpty()) {
                return "";
            }
            return content;
        }

        return null;
    }

    public static double round(double value, int decimalPlaces) {
        BigDecimal decimal = new BigDecimal(value);
        decimal = decimal.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        return decimal.doubleValue();
    }

    public static  <T extends Comparable<T>> int compareNumbers(T number1, T number2) {
        return number1.compareTo(number2);
    }

    public static void main(String[] args) {


        System.out.println(compareNumbers(Double.parseDouble(""),1.1));
        System.out.println(compareNumbers("1","1.1"));
        System.out.println(compareNumbers("12.12","1"));

        System.out.println(compareNumbers(12.13,12.1));
        System.out.println(compareNumbers(12,12));
        System.out.println(compareNumbers(12,12));


        System.out.println(extractContentFromSquareBracket(" this is spart[2]"));
        System.out.println(extractContentFromSquareBracket(" this is spart[]"));
        System.out.println(extractContentFromSquareBracket(" this is spart"));

        double[] arr= new double[]{12.235, 12.556, 12.999,1.356};
        for(int i=0;i<arr.length;i++){

            System.out.println(round(arr[i],2));
        }




    }
}
