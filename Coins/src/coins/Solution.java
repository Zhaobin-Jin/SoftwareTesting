package coins;

public class Solution {
	int[] coins = {1,1,1,5,5,10,20,50};
	
	boolean dividable(int amount) {
		boolean ans=false;
		for(int i=coins.length-1; i>=0;i--) {
		if(amount>=coins[i]){
			amount-=coins[i];
		}
		}
		if (amount==0) {
			ans=true;
		}
		return ans;
}
}