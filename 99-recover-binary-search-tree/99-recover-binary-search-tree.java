class Solution {
    TreeNode first = null;
    TreeNode last = null;
    TreeNode prev = null;
    TreeNode middle = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first != null && last!=null){
            //for non-adjacent nodes
            swap(first,last);
        }
        else if(first!=null && middle!=null){
            //for adjacent nodes
            swap(first,middle);
        }
    }
    
    void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        if(prev!=null && prev.val > root.val){
            
            //If violation happens for 1st time...
            if(first == null){
                //store the larger value from the front to be swapped with the smaller val in the future.
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        
        prev = root;
        inorder(root.right);
    }

    void swap(TreeNode n1, TreeNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}