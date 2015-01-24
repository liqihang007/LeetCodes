//Compare two version numbers version1 and version1.
//If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//You may assume that the version strings are non-empty and contain only digits and the . character.
//The . character does not represent a decimal point and is used to separate number sequences.
//For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//Here is an example of version numbers ordering:
//0.1 < 1.1 < 1.2 < 13.37

public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {
		if(version1.length()==0){version1="0";}
		if(version2.length()==0){version2="0";}
        int point1=version1.length();
        for (int i=0;i<version1.length();i++){
        	if(version1.charAt(i)=='.'){
        		point1=i;break;
        	}
        }
        int point2=version2.length();
        for (int i=0;i<version2.length();i++){
        	if(version2.charAt(i)=='.'){
        		point2=i;break;
        	}
        }
        if(Integer.parseInt(version1.substring(0,point1)) == Integer.parseInt(version2.substring(0,point2))){
        	if(point1==version1.length() && point2==version2.length()){
        		return 0;
        	}
        	else{
        		point1= (point1>=version1.length()) ? version1.length() : point1+1 ;
        		point2= (point2>=version2.length()) ? version2.length() : point2+1 ;
	        		return compareVersion(version1.substring(point1,version1.length()),
	        			version2.substring(point2,version2.length()));
        	}
        }
        else{
        	if(Integer.parseInt(version1.substring(0,point1)) > Integer.parseInt(version2.substring(0,point2))){
        		return 1;
        	}
        	else{
        		return -1;
        	}
        }
    }
	
	public static void main(String[] args) {
		String s="abcdefg";
		System.out.println(compareVersion("1","1.1"));
	}

}
