package Arrays.d2;

import java.util.*;

public class OverlappingArray {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 6}, {3, 8}, {4, 5}, {7, 9}, {10, 11},{0,0},{1,1}};

        intervals = merge(intervals);
        System.out.println(Arrays.deepToString(intervals));
    }



    public static int[][] merge(int[][] intervals) {

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int k=0; k < start.length; k++){
            start[k] = intervals[k][0];
            end[k] = intervals[k][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        ArrayList<int[]> newIntervals = new ArrayList<>();

        int i=0,j=0;

        for (;i < n ;i++){

            if(i == n-1 || start[i+1] > end[i]){
                newIntervals.add(new int[]{start[j],end[i]});
                j=i+1;
            }


        }

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }

    public static int[][] merge1(int[][] intervals) {

        Comparator<? super int[]> arrayComparator = Comparator.comparing(ints -> ints[0]);

        Arrays.sort(intervals, arrayComparator);

        ArrayList<int[]> newIntervals = new ArrayList<>();

        int[] newInterval = new int[2];
        int[] prevInterval = new int[2];

        prevInterval = intervals[0];
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);

            }else{
                newInterval = prevInterval;
                newIntervals.add(newInterval);
                prevInterval = intervals[i];
            }
        }

        newIntervals.add(prevInterval);

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }
}
