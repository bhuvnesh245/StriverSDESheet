package Arrays.d11;

public class NthRootOfNumber {

    public static void main(String[] args) {
        int N = 5, M= 243;


        int start = 1;
        int end = M;
        int mid = (start+end) / 2;

        while (start < end){
            double pow = Math.pow(mid,N);
            if(M == pow){
                System.out.println("This is the number : "+mid);
                break;
            }else if( pow > M){
                end = mid-1;
            }else{
                start = mid+1;
            }


            mid = (start+end)/2;
        }

    }
}
