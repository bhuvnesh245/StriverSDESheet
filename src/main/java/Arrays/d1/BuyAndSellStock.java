package Arrays.d1;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {5,6,1,2,4,3,6,5,7};

        int min = prices[0];
        int max = 0;
        for (int i=1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]- min);
        }

        System.out.println(max);
    }
}
