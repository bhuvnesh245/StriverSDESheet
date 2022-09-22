package Arrays.d4;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutAnyRepeatingCharacter {

    public static void main(String[] args) {

        String s = "tmmzuxt";

        HashSet<Character> charUni = new HashSet<>();

        int left = 0, right =0, max = 0, counter = 0;

        while (left <= right && right < s.length()){

            if(charUni.contains(s.charAt(right))) {
                while (left<= right && s.charAt(left) != s.charAt(right)){
                    charUni.remove(s.charAt(left));
                    left++;
                    counter--;

                }
                left++;
            }else {

                counter++;
            }
            charUni.add(s.charAt(right));
            right++;
            max = Math.max(max, counter);
        }

        System.out.println(max);
    }
}
