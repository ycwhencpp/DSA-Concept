package SegmentTrees;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,-1,3};
        SegementTree segmentTree = new SegementTree(arr);
        try {
            System.out.println(segmentTree.query(0,3));
            System.out.println(segmentTree.update(1, 99));
            System.out.println(segmentTree.query(0,3));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
