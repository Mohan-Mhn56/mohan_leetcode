class Solution {
    public long getDescentPeriods(int[] prices) {
        int cnt = 0;
        long sum = prices.length;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] - prices[i] == 1) {
                cnt++;
                sum += cnt;
            } else {
                cnt = 0;
            }
        }
        return sum;
    }
}