public class BuyAndSellStack {
    public static int buyAndSellStock(int prices[]) {
        int costPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < costPrice) {
                costPrice = prices[i];
            } else {
                profit = prices[i] - costPrice;

            }
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buyAndSellStock(prices));

    }
}
