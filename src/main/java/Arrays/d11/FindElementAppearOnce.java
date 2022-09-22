package Arrays.d11;

public class FindElementAppearOnce {

    public static void main(String[] args) {

        int arr[] = {4,4,7,7,8,8,9,9,10,11,11,12,12,13,13};

        int no = findNumber(arr, 0, arr.length-1);
        System.out.println(no);
    }

    private static int findNumber(int[] arr, int start, int end) {

        if(start == end){
            return arr[end];
        }

        int mid = (start+end)/2;

        if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
            return arr[mid];
        }

        if(mid < end && arr[mid] == arr[mid+1]){
            mid+=1;
        }

        if(mid %2 == 0) {
            return findNumber(arr, start, mid-2);
        }else{
            return findNumber(arr, mid+1 , end);
        }
    }
}
