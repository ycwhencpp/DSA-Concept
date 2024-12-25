package SegmentTrees;

public class Main {
    public static void main(String[] args) {
        TreeInterface segmentTree = new SegementTree();
        int[] arr = new int[] {1,2,-1,3};

        segmentTree.construct(arr);

        segmentTree.displayTree();

    }
}
