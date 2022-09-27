package Arrays.d11;

import java.util.Set;
import java.util.TreeSet;

public class PowerSets {

    public static void main(String[] args) {
        String[] arr = {"A","B","C"};

        Set<String> powerSet = new TreeSet<>();

        populatePowerSet(arr,powerSet,"",0,arr.length);

        System.out.println(powerSet);
    }

    private static void populatePowerSet(String[] arr, Set<String> powerSet,String s, int i, int N) {
        if(i >= N){
            powerSet.add(s);
            return;
        }

        populatePowerSet(arr,powerSet, s+arr[i], i+1, N);
        populatePowerSet(arr,powerSet, s, i+1, N);
    }
}
