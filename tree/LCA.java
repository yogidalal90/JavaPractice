package tree;

public class LCA {
    class Status{
        int found;
        TreeNode anc;
        public Status(int found,TreeNode anc){
            this.found = found;
            this.anc = anc;
        }
    }


    Status LCA(TreeNode root, int node1, int node2){
        if(root == null)
            return new Status(0,null);

        Status leftStat = LCA(root.left,node1,node2);
        if(leftStat.found == 2)
            return new Status(2,leftStat.anc);

        Status rtStat = LCA(root.right,node1, node2);
        if(rtStat.found==2)
            return new Status(2,rtStat.anc);

        int curr = leftStat.found+ rtStat.found;
        if((root.data == node1) || (root.data == node2))
            curr +=1;
        TreeNode ances  = (curr==2)?root:null;
        return new Status(curr,ances);


    }

    TreeNode findLCA(TreeNode root, int p, int q){
        if(root == null){
            return null;
        }

        if(root.data == p || root.data == q){
            return root;
        }

        TreeNode left = findLCA(root.left,p,q);
        TreeNode right = findLCA(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        if(left == null && right == null){
            return null;
        }
        if(left != null){
            return left;
        }else{
            return right;
        }

    }




    public static void main(String[] args) {
       TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        LCA l = new LCA();
        Status s =l.LCA(r, 5,2);
        TreeNode res = l.findLCA(r,3,8);
        System.out.print(s.anc.data+" : ");
        System.out.print(res.data);

        }


}
