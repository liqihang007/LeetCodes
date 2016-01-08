//After robbing those houses on that street, the thief has found himself a new place for his thievery 
//so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
//That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses 
//remain the same as for those in the previous street.
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum 
//amount of money you can rob tonight without alerting the police.

public class HouseRobber2 {

	public int rob(int[] nums) {
		if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int len=nums.length;
        int[] dp=new int[len+1];
        int case1=0;
        int case2=0;
        // case1: have first one not have last one
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2; i<=len-1; i++){ // attention: len-1
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        case1 = dp[len-1]; // attention: len-1
        // case2: have last one not have first one
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=len; i++){ // attention: len
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        case2 = dp[len]; // attention: dp[len] not dp[len-1] as case1
        return Math.max(case1, case2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
