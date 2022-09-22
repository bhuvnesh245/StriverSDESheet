package Arrays.d2;

import java.util.Arrays;

public class MergeSortedArray {


    public static void main(String[] args) {
        int[] nums1 = {1,1, 1, 2, 2, 3, 3, 3, 3, 4, 7, 8, 9 };
                //{-1, 0, 0, 5, 7, 7};
        int[] nums2 = //{1,2,3,4,5,6,7};
                {-1, 2, 2, 4,-1,-3,7,8,10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        merge(nums1, nums1.length, nums2, nums2.length);


        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int gap = (int) Math.ceil((double)(n + m) / 2.0);

        while (gap > 0) {
            int i = 0, j = gap;
            int tempGap = gap;
            for (; tempGap < m + n; tempGap++, i++, j++) {

                if (tempGap < m) {
                    swap(nums1, nums1, i, j);
                } else {
                    if (i < m) {
                        swap(nums1, nums2, i,  Math.abs(j-m));
                    } else {
                        swap(nums2, nums2, Math.abs(i-m), Math.abs(j-m));
                    }
                }
            }

            if(gap == 1){
                gap = 0;
            }else {
                gap = (int) Math.ceil((double) gap / 2.0);
            }

        }
    }


    public static void swap(int[] num1, int[] num2, int i, int j) {

        if (num2[j] < num1[i]) {
            int temp = num2[j];
            num2[j] = num1[i];
            num1[i] = temp;
        }

    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        int gap = (nums1.length) / 2;
        gap = gap % 2 != 0 ? gap + 1 : gap;
        for (int i = nums1.length - nums2.length, j = 0; j < nums2.length && i < nums1.length; i++, j++) {
            nums1[i] = nums2[j];
        }

        int i = 0, j = gap;
        while (gap > 0) {

            for (; j < nums1.length; i++, j++) {

                if (nums1[j] < nums1[i]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[i];
                    nums1[i] = temp;
                }

            }

            gap = gap / 2;
            i = 0;
            j = gap;
        }

    }
}
