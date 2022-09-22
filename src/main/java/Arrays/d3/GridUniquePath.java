package Arrays.d3;

import java.util.Arrays;

public class GridUniquePath {

    public static void main(String[] args) {

        System.out.println(uniquePaths(6,6));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] memoArr : dp){
            Arrays.fill(memoArr, -1);
        }

//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }

       int result = findUniquePath(0,0,m,n,dp);

        System.out.println(Arrays.deepToString(dp));
        return 1;
    }

    private static int findUniquePath(int i, int j, int m, int n, int[][] memo) {


       if((i==m-1 && j== n-1) ){
            return 1;
        }if((i >= m || j >=n ) ){
            return 0;
        }
       else  if(memo[i][j] != -1){
           return memo[i][j];
       }


        return memo[i][j] = findUniquePath(i+1,j,m,n,memo)+ findUniquePath(i,j+1,m,n,memo);
    }
}
