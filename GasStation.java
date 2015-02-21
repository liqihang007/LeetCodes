//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//Note: The solution is guaranteed to be unique.

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gassum=0, costsum=0, start=0,left=0;;
        for(int i=0;i<gas.length;i++){
        	gassum+=gas[i];
        	costsum+=cost[i];
        	left+=gas[i]-cost[i];
        	if(left<0){
        		left=0;
        		start = i+1>gas.length-1? 0 : i+1;
        	}
        }
        if(costsum>gassum)
            return -1;
        else
            return start;
    }
	
	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[]{2,3,1}, new int[]{3,1,2}));
	}

}
