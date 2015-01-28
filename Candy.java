//There are N children standing in a line. Each child is assigned a rating value.
//You are giving candies to these children subjected to the following requirements:
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum candies you must give?

import java.util.*;

public class Candy {

	public static int candy(int[] ratings) {
        if(ratings.length==1){return 1;}
        int [] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
        	if(ratings[i]>ratings[i-1]){
        		candy[i]=candy[i-1]+1;
        	}
        }
        for(int i=ratings.length-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1]){
        		candy[i]=Math.max(candy[i+1]+1, candy[i]);
        	}
        }
        int res=0;
        for(int i=0;i<ratings.length;i++){
        	res+=candy[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(candy(new int[]{1,2,3,4,34,5,8,3,1,1,23,4,5,2,3}));
		System.out.println(candy(new int[]{1,2}));
		System.out.println(candy(new int[]{1,2,1}));
		System.out.println(candy(new int[]{2,1}));
		System.out.println(candy(new int[]{2,2}));
	}
}
