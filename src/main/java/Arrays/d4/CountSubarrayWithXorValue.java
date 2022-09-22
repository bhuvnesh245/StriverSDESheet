package Arrays.d4;

import java.util.HashMap;

public class CountSubarrayWithXorValue {

    public static void main(String[] args) {
        int nums[] = {5,6,7,8,9};
        int B = 5;

        System.out.println(findCountOfSubArray(nums, B));
    }

    private static int findCountOfSubArray(int[] nums, int B) {
        int counter = 0;
        int currentPrefixXor = 0;
        HashMap<Integer, Integer> xorFrequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            currentPrefixXor^=nums[i];

            if(currentPrefixXor == B){
                counter++;
            }

            xorFrequencyMap.put(currentPrefixXor, xorFrequencyMap.getOrDefault(currentPrefixXor,0)+1);

            int Z = currentPrefixXor^B;
            if(xorFrequencyMap.containsKey(Z)){
                counter+=xorFrequencyMap.get(Z);
            }

        }

        return counter;
    }
}
