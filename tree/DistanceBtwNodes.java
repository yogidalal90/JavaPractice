package tree;

public class DistanceBtwNodes {

	public static void main(String[] args) {
		//Create tree
		TreeNode treeNode = new TreeNode();
		TreeNode root = treeNode.createBT();
		int firstNode = 7;
		int secNode = 5;
		// to find LCA
		TreeNode d = distanceUtil(root, firstNode, secNode, -1);

		//distance from root to n1
		int node1 = findLevel(root,firstNode,-1);
		//distance from root to n2
		int node2 = findLevel(root,secNode,-1);
		//distance from root to lca
		int lca = findLevel(root,d.data,-1);


		//distance between node: n1_dist+n2_dist+lca_dist
		int dist = node1+node2-2*lca;
		System.out.println(dist);
	}

	private static TreeNode distanceUtil(TreeNode r, int n1, int n2, int level){
		int d1 =-1;
		int d2= -1;
		if(r == null)
			return null;
		
		if(r.data==n1){
			d1 = level;
			return r;
		}
		if(r.data==n2){
			d2 = level;
			return r;
		}
		TreeNode lt = distanceUtil(r.left, n1, n2, level+1);
		TreeNode rt = distanceUtil(r.right, n1, n2, level+1);
		
		if(lt != null && rt != null){
			
			return r;
		}
		return (lt != null)?lt:rt;
	}

	private static int findLevel(TreeNode r, int data, int level) {

		if (r == null) {
			return -1;
		}
		if (r.data == data) {
			return level;
		}

		int l = findLevel(r.left, data, level + 1);
		return (l != -1) ? l : findLevel(r.right, data, level + 1);
	}
}
