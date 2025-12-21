class Solution {
    private int recFunc(int index1, int index2, String s, String t) {
        // base case
        if (index2<0) return 1; // when all characters matches
        if (index1<0) return 0; // when there is no match

        // explore all ways

        if (s.charAt(index1) == t.charAt(index2)) {
            return recFunc(index1-1, index2-1, s, t) + recFunc(index1-1, index2, s, t);
        } else {
            return recFunc(index1-1, index2, s, t);
        }
        
    }

    private int memoFunc(int index1, int index2, String s, String t, int[][] dp) {
        // base case
        if (index2<0) return 1; // when all characters matches
        if (index1<0) return 0; // when there is no match

        if (dp[index1][index2]!=-1) return dp[index1][index2];
        // explore all ways

        if (s.charAt(index1) == t.charAt(index2)) {
            return dp[index1][index2] = recFunc(index1-1, index2-1, s, t) + recFunc(index1-1, index2, s, t);
        } else {
            return dp[index1][index2] = recFunc(index1-1, index2, s, t);
        }
        
    }

    private int tabuFunc(String s, String t, int[][] dp) {
        // base case
        int n = s.length();
        int m = t.length();
        // dp[0][0] = 1;
        for (int i =0;i<=n;i++) {
            dp[i][0] = 1;
        }
        // why from j=1 because  dp[0][0] = 1;
         for (int j =1;j<=m;j++) {
            dp[0][j] = 0;
        }

        for (int i = 1;i<=n;i++){
            for (int j =1;j<=m;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    private int spaceOpt(String s, String t, int[] prev) {
        // base case
        int n = s.length();
        int m = t.length();
        // dp[0][0] = 1;
      
        prev[0] = 1;
  
        for (int i = 1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0] = 1;
            for (int j =1;j<=m;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
            
        }

        return prev[m];
    }





    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for (int i =0 ;i<=n;i++) {
            for (int j = 0; j<=m;j++) {
                dp[i][j] = -1;
            }
        }

        int[] prev = new int[m+1];
        // for (int i =0;i<=m;i++) {
        //     prev[i] = -1;
        // }

        return spaceOpt(s, t, prev);
        //return tabuFunc(s, t, dp);
        //eturn memoFunc(n-1, m-1, s, t, dp);
        //return recFunc(n-1, m-1, s, t);
        
    }
}