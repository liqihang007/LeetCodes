//Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){return "";}
        if(strs.length==1){return strs[0];}
        else{
        	int minsize=strs[0].length();
        	int whichmin=0;
        	for(int i=1;i<strs.length;i++){
        		if(strs[i].length()<minsize){
        			minsize=strs[i].length();
        			whichmin=i;
        		}
        	}
//        	System.out.println(minsize+" "+whichmin);
        	int res=0;
        	for(int i=0;i<minsize;i++){
        		for(int j=0;j<strs.length-1;j++){
        			if(strs[j].charAt(i) != strs[j+1].charAt(i)){
//        				System.out.println(strs[j].charAt(i)+" "+strs[j+1].charAt(i));
        				return strs[whichmin].substring(0,res);
        			}
        		}
        		res++;
        	}
        	return strs[whichmin];
        }
        
    }
	
	public static void main(String[] args) {
		String[]A=new String[]{"ab","aa"};
		System.out.println(longestCommonPrefix(A));
	}

}
