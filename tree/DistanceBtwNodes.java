package tree;

public class DistanceBtwNodes extends CreateBT {

	public static void main(String[] args) {
		//Create tree
		DistanceBtwNodes bt = new DistanceBtwNodes();
		bt.root = new LNode(1);
		bt.root.left = new LNode(2);
		bt.root.right = new LNode(5);
		bt.root.left.left = new LNode(3);
		bt.root.left.right = new LNode(4);
		bt.root.left.left.left = new LNode(6);
		bt.root.left.left.right = new LNode(7);
		bt.root.left.left.left.right = new LNode(8);

		// to find LCA
		LNode d = bt.distanceUtil(bt.root, 7, 8, -1);

		//distance from root to n1
		int node1 = findLevel(bt.root,7,-1);
		//distance from root to n2
		int node2 = findLevel(bt.root,8,-1);
		//distance from root to lca
		int lca = findLevel(bt.root,d.data,-1);


		//distance between node: n1_dist+n2_dist+lca_dist
		int dist = node1+node2-2*lca;
		System.out.println(dist);
	}

	private LNode distanceUtil(LNode r, int n1, int n2, int level){
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
		LNode lt = distanceUtil(r.left, n1, n2, level+1);
		LNode rt = distanceUtil(r.right, n1, n2, level+1);
		
		if(lt != null && rt != null){
			
			return r;
		}
		return (lt != null)?lt:rt;
	}
}
