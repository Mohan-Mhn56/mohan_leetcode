class Solution {
    public long countDistinct(long n) {
        long dp[]= new long[16];
        dp[0] = 0;
        for(int i=1;i<16;i++){
            dp[i] = (long)Math.pow(9,i) + dp[i-1];
        }
    
        long count = 0;
        String s = Long.toString(n);
        int k = s.length();
        for(int i=0;i<k;i++){
            int p = s.charAt(i)-'0';
            if(p == 0){
                count += dp[k-1-i];
                break;
            }
            count += p * Math.pow(9,k-1-i);
        } 
      return count;
    }
}