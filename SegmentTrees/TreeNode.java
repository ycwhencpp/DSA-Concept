package SegmentTrees;

public class TreeNode implements NodeInterface {

    public int startRange;

    public int endRange;

    private int data;

    private TreeNode rightNode;
    
    private TreeNode leftNode;


    public TreeNode (int _startRange,  int _endRange, int _data) {
        this.startRange = _startRange;
        this.endRange = _endRange;
        this.data = _data;
        this.rightNode = null;
        this.leftNode = null;
    }

    public TreeNode (int _startRange,  int _endRange, int _data, TreeNode _rightNode, TreeNode _leftNode) {
        this.startRange = _startRange;
        this.endRange = _endRange;
        this.data = _data;
        this.rightNode = _rightNode;
        this.leftNode = _leftNode;
    }

    @Override
    public int getData() {
        return this.data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
        
    }

    @Override
    public void showNodeInformation() {
        String str = "=> interval [" + this.startRange +"," + this.endRange + "] , data : " + this.data  + " <=";
        System.out.println(str);
    }

    public TreeNode getLeftNode(){
        return this.leftNode;
    }

    public void setLeftNode(TreeNode node){
        this.leftNode = node;
    }

    public TreeNode getRightNode(){
        return this.rightNode;
    }

    public void setRightNode(TreeNode node){
        this.rightNode = node;
    }



    
}
