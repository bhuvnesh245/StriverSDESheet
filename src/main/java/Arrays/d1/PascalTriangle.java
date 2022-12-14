package Arrays.d1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

        int numRows = 5;
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }

        System.out.println(allrows);

    }

    public void firstSolution(){
        int numRows = 5;
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        if(numRows > 0){
            pascalTriangle.add(Arrays.asList(1));
        }

        for(int i = 0; i < numRows-1; i++){
            List<Integer> previousRow = pascalTriangle.get(i);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            currentRow.add(1);

            for (int j = 1; j <= (i+1)/2; j++){

                currentRow.add(j, (previousRow.get(j)+previousRow.get(j-1)));

                if(currentRow.size() < previousRow.size()+1){
                    currentRow.add(j+1, currentRow.get(j));
                }

            }
            pascalTriangle.add(currentRow);
        }

        System.out.println(pascalTriangle);
    }
}
