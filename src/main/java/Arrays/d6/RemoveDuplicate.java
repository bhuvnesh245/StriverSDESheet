package Arrays.d6;

import java.util.Arrays;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,1,2};

        System.out.println(removeDuplicates(arr));
    }
    public static  int removeDuplicates(int[] nums) {
        int i=0;
        int count =0;
        for(int k=1; k < nums.length; k++){

            if(nums[k] != nums[i]){
                i++;
                nums[i] = nums[k];
                count++;
            }

        }

        i++;
        for(;i<nums.length;i++){

            nums[i] =0;
        }

        System.out.println(Arrays.toString(nums));
        return count;
    }
}
