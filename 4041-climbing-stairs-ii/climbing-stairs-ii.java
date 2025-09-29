class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] d = new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[0]=0;
        for(int i=0;i<n;i++)
            {
                for(int j = 1;j<=3;j++){
                    int g=i+j;
                    if(g<=n){
                        d[g]=Math.min(d[g],d[i]+costs[g-1]+j*j);
                    }
                }
            }
        return d[n];
        
        
    }
}