import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        TreeNode ls = root.left;
        TreeNode rs = root.right;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(ls);
        q2.add(rs);

        while(!q1.isEmpty() || !q2.isEmpty()){
            if(q1.size()==0 || q2.size()==0)
                return false;
            TreeNode t1 = q1.remove();
            TreeNode t2 = q2.remove();
            if(t1==null && t2==null)
                continue;

            if(t1==null || t2==null)
                return false;

            if(t1.val!=t2.val)
                return false;

            if(t1!=null){
                q1.add(t1.left);
                q1.add(t1.right);
            }
            if(t2!=null){
                q2.add(t2.right);
                q2.add(t2.left);
            }
        }
        return true;
    }
}
