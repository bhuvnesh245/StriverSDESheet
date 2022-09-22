package Arrays.d11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMedian {

    public static void main(String[] args) {

        ArrayList<List<Integer>> matrix = new ArrayList<>();

        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 8));


        matrixMedianWithBinarySearch(matrix);

    }

    private static void matrixMedianWithBinarySearch(ArrayList<List<Integer>> matrix){

        int start = 0;
        int end = 50;
        int count = 0;
        int mid = 0;
        int totalCount = (matrix.size()*matrix.get(0).size())/2;
        int ans = 0;
        while (start<=end){
            mid = (start+end)/2;

            count = findLessCount(mid, matrix);

            if(count <= totalCount){
                ans=mid;
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        System.out.println(ans);
    }

    private static int findLessCount(int mid, ArrayList<List<Integer>> matrix) {

        int n = matrix.size();
        int m = matrix.get(0).size();
        int count = 0;
        for(int i = 0; i < matrix.size(); i++){

            if(matrix.get(i).get(m-1) <= mid){
                count+=m;
            }else if ( matrix.get(i).get(0) < mid){
                int start = 0;
                int end = m-1;
                int mi = 0;
                int ans = 0;

                while (start <= end){
                    mi = (start+end)/2;

                    if(matrix.get(i).get(mi)  < mid){
                        ans=mi;
                        start = mi+1;
                    }else{
                        end = mi-1;
                    }
                }

                count+=ans+1;
            }
        }
        return count;
    }

    private void matrixMedianWithMergeSort(ArrayList<List<Integer>> matrix){
        int start =0,R = matrix.size(), C= matrix.get(0).size(), end = (R*C)-1;
        mergeSortMatrix(matrix, start,end, R,C);

        int middle = (R*C)/2;
        int median =  matrix.get(getRow(middle,C)).get(getCol(middle, C));
        System.out.println(matrix);
        System.out.println(median);
    }

    private static void mergeSortMatrix(ArrayList<List<Integer>> matrix, int start, int end, int row, int col) {

        if (start < end){
            int mid = (start+end)/2;

            mergeSortMatrix(matrix, start, mid, row, col);
            mergeSortMatrix(matrix, mid+1, end, row, col);
            mergeSort(matrix, start, mid, end, row, col);
        }

    }

    private static void mergeSort(ArrayList<List<Integer>> matrix, int start, int mid, int end, int row, int col) {

        int[] tempRow = new int[start+end+1];

        for (int i = start ; i <= end ; i++){
            int rowT = getRow(i,col);
            int colT = getCol(i,col);;
            tempRow[i] = matrix.get(rowT).get(colT);
        }

        int k = start;
        int p = start;
        int q = mid+1;

        while (p <= mid && q <=end ){
            int rowK = getRow(k,col);
            int colK = getCol(k,col);

            if(tempRow[q] <= tempRow[p]){
                matrix.get(rowK).set(colK , tempRow[q]);
                q++;
            }else {
                matrix.get(rowK).set(colK , tempRow[p]);
                p++;
            }

                k++;
        }

        while (p<=mid){
            int rowK = getRow(k,col);
            int colK = getCol(k,col);
            matrix.get(rowK).set(colK , tempRow[p]);
            k++;
            p++;
        }

        while (q<=end){
            int rowK = getRow(k,col);
            int colK = getCol(k,col);
            matrix.get(rowK).set(colK , tempRow[q]);
            k++;
            q++;
        }
    }

    static  int getRow(int  i, int col){

        return i/col;
    }

    static  int getCol(int  i, int col){
        return col>0 ? i%col :col;
    }
}
