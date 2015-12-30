//The code base version is an integer and start from 1 to n. 
//One day, someone commit a bad version in the code case, so it caused itself and the following versions are all failed in the unit tests.
//You can determine whether a version is bad by the following interface: 
//Java:
//    public VersionControl {
//        boolean isBadVersion(int version);
//Find the first bad version.
//You should call isBadVersion as few as possible. 
//Please read the annotation in code area to get the correct way to call isBadVersion in different language. 
//For example, Java is VersionControl.isBadVersion.
//Example, Given n=5
//Call isBadVersion(3), get false
//Call isBadVersion(5), get true
//Call isBadVersion(4), get true
//return 4 is the first bad version

public class FirstBadVersion extends VersionControl {

	public int findFirstBadVersion(int n) {
        int a=0,b=n,res=0;
        while(a<b){
            int mid=a+(b-a)/2;
            if(isBadVersion(mid))
                b=mid;
            else
                a=mid+1;
        }
        return a;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
