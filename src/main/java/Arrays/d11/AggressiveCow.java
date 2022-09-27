package Arrays.d11;

public class AggressiveCow {

    public static void main(String[] args) {
        int barn [] = {1,3,6,9,10,13,14,17};
        int N = 4;
        int low = 1;
        int high = barn[barn.length-1]-barn[0];
        int midMax = Integer.MIN_VALUE;

        for (int i=1; i <=high; i++){
            if(cowOccupied(barn, i, N)) {
                midMax = Math.max(midMax, i);
            }
        }

        System.out.println(midMax);
    }

    private static boolean cowOccupied(int[] barn, int mid, int N) {
        int k = barn[0];
        N--;
        for (int i =1; i <barn.length; i++){

            if(barn[i]-k >= mid){
                k= barn[i];
                N--;
                if(N==0){
                    return true;
                }
            }


        }

        return false;
    }
}
