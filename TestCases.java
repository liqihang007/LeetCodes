
public class TestCases {

	
	public static void main(String[] args) {
		LRUCache c = new LRUCache(6);
		c.set(195,835);
		c.get(494);
		c.set(301,162);
		c.get(36);
		c.get(444);
		c.set(138,1088);
		c.set(200,1138);
		c.get(335);
		c.get(263);
		System.out.println(c.map);
		
		
		TreeNode n1=new TreeNode(3);
		TreeNode n2=new TreeNode(9);
		TreeNode n3=new TreeNode(20);
		TreeNode n4=new TreeNode(15);
		TreeNode n5=new TreeNode(7);
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n3.right=n5;
		System.out.println(levelOrder(n1));
		
	}

}
