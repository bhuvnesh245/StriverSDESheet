package Arrays.d1;

import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int row = matrix.length;
        int column = matrix[0].length;
        int col0 = 1;


        for (int i=0; i < row; i++){
            if(matrix[i][0] == 0) col0 = 0;
            for (int j=1; j<  column; j++){

                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i=row-1; i >= 0; i--){
            for (int j=column-1; j>=1; j--){

                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) matrix[i][0] = 0;
        }

        System.out.println(Arrays.deepToString(matrix));

    }

    private static void markPerviousZero(int[][] matrix, int i, int j, boolean rowOperation) {

        while (j >=0 && rowOperation){
            matrix[i][j--]=0;
        }


        while (i >=0 && !rowOperation){
            matrix[i--][j]=0;
        }
    }
}
