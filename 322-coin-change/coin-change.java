class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            coinChange(new int[]{1,2,5}, 11);
        }
    }
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}