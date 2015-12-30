//Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
//You may assume that each word will contain only lower case letters. 
//If no such two words exist, return 0.
//Example 1:
//Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
//Return 16
//The two words can be "abcw", "xtfn".
//Example 2:
//Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
//Return 4
//The two words can be "ab", "cd".
//Example 3:
//Given ["a", "aa", "aaa", "aaaa"]
//Return 0
//No such pair of words.

/**
*		  This is taken care by creating a unique number for every string. Image
*         a 32 bit integer where 0 bit corresponds to 'a', 1st bit
*         corresponds to 'b' and so on.
*         Thus if two strings contain the same character when we do and
*         "AND" the result will not be zero and we can ignore that case.
*/
public class MaximumProductofWordLengths {

	public static int maxProduct(String[] words) {
		int[] mask=new int[words.length];
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++)
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
        }
        int res=0;
        for(int i=0; i<words.length-1; i++) {
            for(int j=i+1; j<words.length; j++) {
                if((mask[i] & mask[j]) == 0) {
                    res=Math.max(words[i].length()*words[j].length(), res);
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
	}

}
