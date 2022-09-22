package Arrays.d11;

public class FindNumberInRotatedArray {

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1,1,1,0};
        System.out.println(findNumber(arr,0, arr.length-1, 0));
    }

    public static int findNumber(int[] arr, int start, int end, int find){

        int mid = (start + end)/2;

        if( arr[mid] == find){
            return mid;
        }else if( arr[start] == find){
            return start;
        }else if( arr[end] == find){
            return end;
        }else if(start>= end){
            return -1;
        }else if((arr[start] < arr[mid] && find >= arr[start])
                || ( arr[start] > arr[mid] &&  find <= arr[mid])){
            return findNumber(arr,start,mid-1,find);
        }else{
            return findNumber(arr,mid+1,end,find);
        }
    }
}
