package javaPackage;

import java.util.Scanner;

public class NumberToWord {

    private static Scanner s = new Scanner(System.in);

    private static String DigitToWord(int digit){
        switch (digit){
            case 1: return "one ";
            case 2: return "two ";
            case 3: return "three ";
            case 4: return "four ";
            case 5: return "five ";
            case 6: return "six ";
            case 7: return "seven ";
            case 8: return "eight ";
            case 9: return "nine ";
        }
        return "";
    }

    private static String tensDigitToWord(int digit){

        if(digit<10){
            return DigitToWord(digit);
        }
        else if(digit/10 == 1){
            switch (digit){
                case 10: return "ten ";
                case 11: return "eleven ";
                case 12: return "twelve ";
                case 13: return "thirteen ";
                case 14: return "fourteen ";
                case 15: return "fifteen ";
                case 16: return "sixteen ";
                case 17: return "seventeen ";
                case 18: return "eighteen ";
                case 19: return "nineteen ";
            }
        }
        else {
            switch (digit/10){
                case 2: return "twenty " + DigitToWord(digit%10);
                case 3: return "thirty " + DigitToWord(digit%10);
                case 4: return "forty " + DigitToWord(digit%10);
                case 5: return "fifty " + DigitToWord(digit%10);
                case 6: return "sixty " + DigitToWord(digit%10);
                case 7: return "seventy " + DigitToWord(digit%10);
                case 8: return "eighty " + DigitToWord(digit%10);
                case 9: return "ninety " + DigitToWord(digit%10);
            }
        }
        return "";
    }

    private static String getWord(int threeDigitNumber){

        String word = threeDigitNumber/100 == 0 ? "" : DigitToWord(threeDigitNumber/100) + " hundred";

        if(threeDigitNumber/100 > 0 && threeDigitNumber%100 > 0)
            word += " and ";

        if(threeDigitNumber%100>0)
            return word + tensDigitToWord(threeDigitNumber%100);

        return word;
    }

    private static String countValue(int count){

        String result = "";

        if(count==1)
            result  =  "thousand ";

        if(count==2)
            result = "million ";

        return result;
    }

    public static void main(String[] args) {

        System.out.print("Enter number of test cases: ");
        int testCases = s.nextInt();

        while (testCases-- > 0){
            System.out.print("Enter number: ");
            long number = s.nextLong();

            String word = "";

            int count = 0;

            while(number>0){

                word = getWord((int)number%1000) + countValue(count) + word;

                number /= 1000;

                count++;

            }
            System.out.println(word);
        }
    }
}