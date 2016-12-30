package codeReview.DataStructure;


public class RangeSumQuery {

    private SegmentTree tree;
    private SegmentTree.Node root;
    private int[] nums;

    public RangeSumQuery(int[] nums) {
      int length = nums.length;
      this.nums = new int[length];

      tree = new SegmentTree();
      root = tree.build(0, length-1);
      for(int i = 0; i < length; i++) {
        tree.add(root, i, nums[i]);
        this.nums[i] = nums[i];
      }
    }

    public void update(int i, int val) {
      tree.add(root, i, val - nums[i]);
      nums[i] = val;
    }

    public int sumRange(int i, int j) {
      return tree.query(root, i, j);
    }

}
