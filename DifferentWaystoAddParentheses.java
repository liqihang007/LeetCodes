//Given a string of numbers and operators, return all possible results from computing all the 
//different possible ways to group numbers and operators. The valid operators are +, - and *.
//Example 1
//Input: "2-1-1".
//((2-1)-1) = 0
//(2-(1-1)) = 2
//Output: [0, 2]
//Example 2
//Input: "2*3-4*5"
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
//Output: [-34, -14, -10, -10, 10]
		
public class DifferentWaystoAddParentheses {
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> list=new ArrayList();
	    if(input==null||input.length()==0) return list;
	    if(!input.contains("+") && !input.contains("-") && !input.contains("*")) { // one value or the last one
	        list.add(Integer.valueOf(input));
	        return list;
	    }
	    for(int i=0;i<input.length();i++){ // recursive parsing the values
	    	char ops=input.charAt(i);
	    	if(ops=='+' || ops=='-' || ops=='*'){
	    		List<Integer> leftList=diffWaysToCompute(input.substring(0,i));
	            List<Integer> rightList=diffWaysToCompute(input.substring(i+1,input.length()));
	            for(int leftValue:leftList){
	                for(int rightValue:rightList){
	                    switch(ops){
	                        case '+': list.add(leftValue+rightValue); break;
	                        case '-': list.add(leftValue-rightValue); break;
	                        case '*': list.add(leftValue*rightValue); break;
	                    }
	                }
	            }
	        }
	    }
	    return list;
    }
}
