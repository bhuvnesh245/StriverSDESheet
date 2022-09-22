package Arrays.d1;

public class Kadane {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        solutionOptimize(nums);
    }

    private static void solutionOptimize(int[] nums) {

        int max = nums[0];
        for (int i=1 ; i < nums.length; i++ ){

            nums[i] = (nums[i] + nums[i-1]) > nums[i] ? (nums[i] + nums[i-1]) : nums[i];

            max = Math.max(nums[i], max);
        }

        System.out.println(max);
    }

    private static void solutionOriginal(int[] nums) {

        int max = nums[0];
        for (int i=1 ; i < nums.length; i++ ){
            int addition = nums[i-1] + nums[i];
            if( addition > nums[i]){
                nums[i] = addition;
            }

            if(nums[i] > max){
                max = nums[i];
            }
        }

        System.out.println(max);
    }
}
