package Arrays.d11;

public class AllocateMinimumNoOfPages {

    public static void main(String[] args) {
        int[] pages = {3, 10, 2, 8, 15};
        int person = 3;
        int low = Integer.MAX_VALUE;
        int high = 0;
        int minMax = Integer.MAX_VALUE;
        for (int page : pages){
            high+=page;
            low = Math.min(low, page);
        }
        int mid = 0;
        while (low <= high){
            mid = (low+high) / 2;

            if(isPossible(pages,person,mid)){
                minMax = Math.min(minMax,mid);
                high = mid-1;
            }else{
                low=mid+1;
            }
        }

        System.out.println(low);
    }

    private static boolean isPossible(int[] pages, int person, int page) {

        int cnt = 0;
        int totalPages = 0;
        for (int i= 0; i < pages.length; i++){

            if(totalPages+pages[i] > page){
                cnt++;
                totalPages = pages[i];
                if(totalPages > page) return  false;
            }else{
                totalPages+=pages[i];
            }


        }

        if(cnt < person) return true;
        return false;
    }
}
