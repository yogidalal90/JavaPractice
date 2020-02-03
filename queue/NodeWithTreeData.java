package queue;

import tree.TreeNode;

public class NodeWithTreeData {
	public TreeNode data;
	public NodeWithTreeData next;

	public NodeWithTreeData(TreeNode data){
		this.data = data;
		this.next = null;
	}

	NodeWithTreeData(TreeNode data, NodeWithTreeData next){
		this.data = data;
		this.next = next;
	}

	public NodeWithTreeData() {
	}

	/**
	 * 1 --> 2  --> 3 --> 4 --> 6
	 * @return
	 */
	public static NodeWithTreeData createLL (){

		NodeWithTreeData n5 = new NodeWithTreeData(new TreeNode(1));
		NodeWithTreeData n4 = new NodeWithTreeData(new TreeNode(2),n5);
		NodeWithTreeData n3 = new NodeWithTreeData(new TreeNode(3),n4);
		NodeWithTreeData n2 = new NodeWithTreeData(new TreeNode(4),n3);
		NodeWithTreeData n1 = new NodeWithTreeData(new TreeNode(5),n2);
	//    n1.next.next.next.next = n1;
		return n1;
		
	}
	
	static void printLL (NodeWithTreeData n){
		if(n==null){
			return;
		}
		System.out.print(n.data+" ");
		if(n.next !=null)
			printLL(n.next);
	}

	/*static void insertElement(NodeWithTreeData n, TreeNode ele, NodeWithTreeData prev){
		if(n==null && prev == null){
			n = new NodeWithTreeData(ele);
			return;
		}
		if(n==null){
			NodeWithTreeData temp = new NodeWithTreeData();
			temp = prev.next;
			prev.next = new NodeWithTreeData(ele, temp);
		}
		if(n.data < ele){
			insertElement(n.next, ele,n);
		}
		else 
		{
			NodeWithTreeData temp = new NodeWithTreeData();
			temp = prev.next;
			prev.next = new NodeWithTreeData(ele, temp);
		}	
	}*/
}