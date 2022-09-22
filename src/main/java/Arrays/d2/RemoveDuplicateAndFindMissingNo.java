package Arrays.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicateAndFindMissingNo {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1,2,3,5,5);

        repeatedNumber(input);


    }

    public static  ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        int duplicate = 0;

        int freq[] = new int[A.size()+1];

        for(int i = 0; i < A.size(); i++ ){
            sum+=A.get(i);
            freq[A.get(i)] += 1;
            if(freq[A.get(i)] == 2){
                duplicate = A.get(i);
            }
        }

        result.add(duplicate);

        int a = (A.size()*(A.size()+1)) / 2;
        int b = (sum-result.get(0));
        int missingNo =  a > b ? a-b : b-a;

        result.add(missingNo);

        System.out.println(result);

        return  result;
    }
}
