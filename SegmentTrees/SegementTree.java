package SegmentTrees;

public class SegementTree implements TreeInterface {

    TreeNode root;

    public SegementTree(int[] arr){
        construct(arr);
    }

    @Override
    public void construct(int[] arr) {
        root = buildTree(arr, 0, arr.length-1);
    }

    @Override
    public void displayTree() {
       displayTreeData(this.root);
    }

    @Override
    public int update(int index, int data) throws Exception {
        if(!isValidIndex(index, index)){
            throw new Exception("Invalid Index provided");
        }
        return _updateNode(this.root, index, data);
    }

    private TreeNode buildTree(int[] arr, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            TreeNode node = new TreeNode(startIndex, endIndex, arr[startIndex]);
            return node;
        }
        TreeNode node = new TreeNode(startIndex, endIndex,0);

        int mid = startIndex + (endIndex - startIndex)/2;

        TreeNode leftNode = buildTree(arr, startIndex, mid);
        node.setLeftNode(leftNode);

        TreeNode rightNode = buildTree(arr, mid+1, endIndex);
        node.setRightNode(rightNode);

        int data = leftNode.getData() + rightNode.getData();
        node.setData(data);

        return node;
    }

    private void displayTreeData(TreeNode root){
        if(root.getLeftNode() == null || root.getRightNode() == null){
            System.out.println("Leaf Node");
            return;
        }
        TreeNode leftNode = root.getLeftNode();
        leftNode.showNodeInformation();

        root.showNodeInformation();

        TreeNode rightNode = root.getRightNode();
        rightNode.showNodeInformation();

        displayTreeData(leftNode);

        displayTreeData(rightNode);

    }

    private int _updateNode(TreeNode root, int index, int data){
        if(root.startRange <= index && root.endRange >= index) {
            if(root.startRange == index || root.endRange == index){
                root.setData(data);
                return root.getData();
            }

            int left = _updateNode(root.getLeftNode(), index, data);
            int right = _updateNode(root.getRightNode(), index, data);

            root.setData(left+right);
            return right+left;
        }
        return root.getData();
        
    }


    public int query(int startIndex, int endIndex) throws Exception{
        if(!isValidIndex(startIndex, endIndex)) throw new Exception("Invalid Index Provided");
        return _query(this.root, startIndex, endIndex);
    }

    private int _query(TreeNode root, int startIndex, int endIndex){
        int si = root.startRange;
        int ei = root.endRange;
        if (si >= startIndex && ei <= endIndex) { // a chunk since its range is inside my target range
            return root.getData();
        } else if(ei < startIndex || si > endIndex) { //out of bound
            return 0;
        } else{
            return _query(root.getLeftNode(), startIndex, endIndex) + _query(root.getRightNode(), startIndex, endIndex);
        }
    }

    private boolean isValidIndex(int start, int end){
        return !(this.root.startRange> start || this.root.endRange < end);
    }
    
}
