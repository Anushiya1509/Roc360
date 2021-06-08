package javaPackage;

import java.util.Scanner;

public class Palindrome {

    private static Scanner s = new Scanner(System.in);

    private static boolean checkPalindrome(String word){
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return sb.toString().equals(word) ? true : false;
    }

    public static void main(String[] args) {

        System.out.print("Enter number of test cases: ");
        int t = s.nextInt();

        while(t-- > 0){
            System.out.print("Enter word: ");
            String word = s.next();

            int length = word.length();

            System.out.println(checkPalindrome(word) ? "Yes" : "No");
        }
    }
}
