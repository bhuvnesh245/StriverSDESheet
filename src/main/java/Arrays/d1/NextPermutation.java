package Arrays.d1;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {7,6,1,2,3,4};

       solution(nums);
    }

    private static void solution(int[] nums) {

        int lastIndex = nums.length-1;
        int pivot = 0;

        for(int i= lastIndex-1; i >=0; i--){

            if(nums[i] < nums[i+1]){
                pivot=i;
                break;
            }
        }

        for(int i = lastIndex; i > pivot; i--){
            if(nums[i] >= nums[pivot]){
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                pivot++;
                break;
            }
        }

        while (pivot < lastIndex){
            int temp = nums[pivot];
            nums[pivot] = nums[lastIndex];
            nums[lastIndex] = temp;
            pivot++;
            lastIndex--;
        }

        System.out.println(Arrays.toString(nums));
    }
}
