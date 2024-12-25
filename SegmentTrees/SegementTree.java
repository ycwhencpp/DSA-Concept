package SegmentTrees;

public class SegementTree implements TreeInterface {

    TreeNode root;

    @Override
    public void construct(int[] arr) {
        root = buildTree(arr, 0, arr.length-1);
    }

    @Override
    public void displayTree() {
       displayTreeData(this.root);
    }

    @Override
    public void update(int index, int data) throws Exception {
        if(this.root.startRange> index || this.root.endRange < index){
            throw new Exception("Invalid Index provided");
        }
        _updateNode(this.root, index, data);
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

    private void _updateNode(TreeNode root, int index, int data){
        if(root.startRange == index || root.endRange == index){
            root.setData(data);
            return;
        }
        if(root.getLeftNode() != null) _updateNode(root.getLeftNode(), index, data);
        if(root.getRightNode() != null) _updateNode(root.getRightNode(), index, data);
    }
    
}
