package Arrays.d3;

import java.util.Arrays;

public class ReversePair {

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println(reversePair(nums));
    }

    private static int reversePair(int[] nums) {

        return mergeSort(nums,0,nums.length-1);
    }

    private static int mergeSort1(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int cnt = mergeSort1(nums, s, mid) + mergeSort1(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }

    private static int mergeSort(int[] nums, int s, int e) {

        if(s>=e){
            return 0;
        }

        int mid =s + (e-s)/2;

        int cnt = mergeSort(nums,s,mid) + mergeSort(nums, mid+1, e);

        for(int i = s,j=mid+1; i<=mid; i++){
            while (j<=e && nums[i]/2.0 > nums[j]){
                j++;
            }
            cnt+=j-(mid+1);
        }

        merge(nums,s,mid,e);

        return cnt;
    }

    private static void merge(int[] nums, int s, int mid, int e) {
        int temp[] = new int[nums.length];

        for (int i =s ; i <=e; i++){
            temp[i] =  nums[i];
        }

        int l = s;
        int r = mid+1;
        int i = s;
        while ( l <= mid || r <=e){

            if(l>mid  || (r <= e && temp[l] >= temp[r])){
                nums[i++] = temp[r++];
            }else{
                nums[i++] = temp[l++];
            }

        }
    }
}
