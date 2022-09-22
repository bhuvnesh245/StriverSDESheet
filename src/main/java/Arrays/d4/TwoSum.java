package Arrays.d4;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target =17;

        //fastest way is using map time complexity O(n) space O(n)


        Arrays.toString(twoSum(nums,target));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i=0; i< nums.length; i++){
            for (int j=i+1; j < nums.length; j++){

                if(target == nums[i]+nums[j]){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

}
