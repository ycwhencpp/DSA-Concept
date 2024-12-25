package SegmentTrees;

public interface TreeInterface {

    public NodeInterface construct(int[] arr);

    public void update(NodeInterface node, int data);

    public void displayTree();

    
} 