package Arrays.d6;

import java.util.Arrays;

public class ProductOfArray {

    public static void main(String[] args) {
        int[] nums = {-1,1,-3,-1};
        int[] product = productOfArray(nums);

        System.out.println(Arrays.toString(product));
    }

    private static int[] productOfArray(int[] nums) {
        int productArr[] = new int[nums.length];

        int zeroCount = 0;
        int product = 1;
        for (int i=0; i< nums.length; i++){

            if(nums[i] == 0){
                zeroCount++;
            }else{
                product*=nums[i];
            }
        }

        for(int i =0; i < nums.length; i++){

            if(zeroCount >=1){
                if(zeroCount > 1) {
                    productArr[i] = 0;
                }else  if(nums[i] == 0) {
                    productArr[i] = product;
                }
            }else {
                productArr[i] = product/nums[i];
            }

        }

        return productArr;
    }
}
