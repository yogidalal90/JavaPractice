package tree;



/**
 * Tree traversals recursively
 *              Tree Structure
 *                      1
 *                  2        3
 *              4      5  6      7
 */
public class BinaryTreeTraversals {
    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        System.out.print("PREORDER: "); preOrder(r);
       System.out.print("\nINORDER: "); inOrder(r);
        System.out.print("\nPOSTORDER: "); postOrder(r);
        System.out.print("\nSEARCH TREE: " + searchTree(r,4));
        System.out.print("\nLEAF NODES: "); leafNodes(r);
        System.out.print("\nNON LEAF NODES: "); nonLeafNodes(r);
        System.out.print("\nODD NODES: "); oddNodes(r);
        System.out.print("\nODD NODES COUNT: "+ countOddNodes(r));
        System.out.print("\nSUM OF CHILDREN: "+ sumOfChildren(r));
        System.out.print("\nPREORDER BEFORE ADDING SUM OF CHILDREN AT EACH NODE: "); preOrder(r);
        addSumOfChildren(r);
        System.out.print("\nPREORDER AFTER ADDING SUM OF CHILDREN AT EACH NODE: "); preOrder(r);
        treeMirrorImage(r);
        System.out.print("\nPREORDER OF MIRROR IMAGE: "); preOrder(r);
        System.out.print("\nPRINT LEVEL OF NODE IN TREE: "+ findNodeLevel(r,4)+"\n");
        System.out.print("\nPRINT ALL ANCESTOR OF A NODE IN TREE: "+ printAncestor(r,7));
        System.out.print("\nINORDER OF MIRROR IMAGE: "); inOrder(r);
        System.out.print("\nPRINT kTH NODE OF A TREE IN INORDER: "); kthNode(r,2,0);
        System.out.print("\nPRINT LEFT VIEW OF TREE: "); leftView(r);
      

    }

    /**
     * Find Kth node in inorder traversal of binary tree
     */
    private static void kthNode(TreeNode r,int pos, int currPos){
        if(r == null) {
            return ;
        }

        kthNode(r.left,pos,currPos);
        currPos++;
        if(currPos == pos) {

            System.out.print(r.data + "  " + currPos + " : ");

        }

        kthNode(r.right,pos,currPos);
    }
    /**
     * Print all ancestors of a node in tree
     */
    public static boolean printAncestor(TreeNode r, int data){
        if(r == null){
            return false;
        }
        if(r.data == data) { return true; }
        if(printAncestor(r.left,data) || printAncestor(r.right,data)) {
            System.out.print(r.data+" ");
            return true;
        }
        return false;
    }
    /**
     * Find level of a particular node in tree
     */
    public static int findNodeLevel(TreeNode r, int value){
        if(r == null){
            return -1;
        }
        if(r.data == value){
            return 0;
        }
        int level = findNodeLevel(r.left,value);
        if(level != -1){
            return  level +1;
        }
        level=  findNodeLevel(r.right,value);
        if(level != -1){
            return  level +1;
        }
        return -1;
    }

    /**
     * Add sum of children nodes to its parent node
     * @param r
     */
    public static void addSumOfChildren(TreeNode r){
        if(r==null) { return ; }
        if(r.left != null ) {
            addSumOfChildren(r.left);
            r.data += r.left.data;
        }
        if(r.right != null) {
            addSumOfChildren(r.right);
            r.data +=r.right.data;
        }
    }
    /**
     * Sum of all nodes in a binary tree
     * @param r
     * @return
     */
    public static int sumOfChildren(TreeNode r){
        if (r==null) {
            return 0;
        }
        if(r.left == null && r.right == null) {
            return r.data;
        }
        if(r.left == null && r.right != null) {
            return r.right.data+r.data;
        }
        if(r.right == null && r.left != null) {
            return r.left.data +r.data;
        }
        return r.data+sumOfChildren(r.left) + sumOfChildren(r.right);
    }


    /**
     * Create tree mirror image
     * @param r
     */
    public static void treeMirrorImage(TreeNode r){
        if(r== null){
            return;
        }
        treeMirrorImage(r.left);
        treeMirrorImage(r.right);
        TreeNode temp = r.left;
        r.left = r.right;
        r.right =temp;

    }

    public static void preOrder(TreeNode r){
        if(r == null) return;
        System.out.print(r.data+" ");
        if(r.left != null)
             preOrder(r.left);
        if(r.right != null)
            preOrder(r.right);
    }

    public static void inOrder(TreeNode r){
        if(r == null) return;
        if(r.left != null)
           inOrder(r.left);
        System.out.print(r.data+" ");
        if(r.right!= null)
            inOrder(r.right);
    }

    public static void postOrder(TreeNode r){
        if(r == null) return;
        if(r.left != null)
           postOrder(r.left);
        if(r.right != null)
          postOrder(r.right);
        System.out.print(r.data+" ");
    }

    public static boolean searchTree(TreeNode r, int x) {
        if(r == null)
            return false;
        if(r.data == x)
            return true;
        return  searchTree(r.left,x) || searchTree(r.right,x);
    }

    public static void leafNodes(TreeNode r){
        if(r == null) return;
        if(r.left == null && r.right == null) {
            System.out.print(r.data + " ");
        }
        leafNodes(r.left);
        leafNodes(r.right);

    }

    public static void nonLeafNodes(TreeNode r){
        if(r==null) return;
        if(r.right != null && r.left != null) {
            System.out.print(r.data+" ");
        }
        nonLeafNodes(r.left);
        nonLeafNodes(r.right);

    }

    public static void oddNodes(TreeNode r){
        if(r == null) return;
        if(r.data%2 != 0) {
            System.out.print(r.data + " ");
        }
        oddNodes(r.left);
        oddNodes(r.right);
    }

    public static int countOddNodes(TreeNode r){
        if(r == null) return 0;

        int x= countOddNodes(r.left);
        int y = countOddNodes(r.right);
        if(r.data%2 != 0){
            return x+y+1;
        } else {
            return  x+y;
        }
    }

    public static void leftView(TreeNode root){
        if(root == null){
            return;
        }
        leftViewTree(root, 1);
    }

    static int maxLevel =0;
    public static void leftViewTree(TreeNode root, int level){
        if (root == null) {
            return;
        }

        if(maxLevel < level){
            System.out.print(root.data+" ");
            maxLevel = level;
        }
        leftViewTree(root.left,level+1);
        leftViewTree(root.right,level+1);
    }

   
}
