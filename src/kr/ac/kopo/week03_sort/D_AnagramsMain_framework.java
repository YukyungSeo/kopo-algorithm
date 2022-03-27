package kr.ac.kopo.week03_sort;

import java.util.Arrays;
import java.util.Scanner;

public class D_AnagramsMain_framework {

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------
         *
         * Your code should return true if the two strings are anagrams of each other.
         *
         * */
    	
    	char[] word1 = first.toCharArray();
		char[] word2 = second.toCharArray();
		
		Arrays.sort(word1);
		Arrays.sort(word2);
		
		String str1 = new String(word1);
		String str2 = new String(word2);

		if (str1.equals(str2))
			return true;

        return false;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
        
        sc.close();
    }
}
