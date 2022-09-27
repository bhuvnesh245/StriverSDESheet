package Arrays.d11;

public class FindMedianSortedArray {

    public static void main(String[] args) {
        int arr1[]= {1,3,5,6,7,9};
        int arr2[] = {2,4,6};
        int median = (arr1.length+arr2.length)/2;
        int l1 = 0, r1=0, l2=0,r2=0;

        if(arr1.length <= arr2.length){
            l1= arr1.length/2;
            l2 = median-l1;
        }else{
            l2 =arr2.length/2;
            l1 = median-l2;
        }


        r1 =l1+1;
        r2=l2+1;
    }
}
