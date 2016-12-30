package com.ms;

import codeReview.Utilities.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangdong on 11/19/16.
 */
public class PopulatingNextRightPointersInEachNode {
  public void connect(TreeLinkNode root) {
    if(root == null) {
      return;
    }

    TreeLinkNode left = root.left;
    TreeLinkNode right = root.right;

    if(left != null) {
      left.next = right;
    }
    if(right != null && root.next != null) {
      right.next = root.next.left;
    }
    connect(left);
    connect(right);
  }

  public void connectByleverOrder(TreeLinkNode root) {
    if(root == null) {
      return;
    }

    TreeLinkNode end = new TreeLinkNode(-1);
    Queue<TreeLinkNode> levelOrder = new LinkedList<>();

    levelOrder.add(root);
    levelOrder.add(end);

    while (!levelOrder.isEmpty()) {
      TreeLinkNode cur = levelOrder.poll();
      if(cur == end) {
        if(!levelOrder.isEmpty()) {
          //this level finished, add end flag to next level
          levelOrder.add(cur);
          continue;
        }

        if(levelOrder.peek() != end) {
          cur.next = levelOrder.peek();
        } else {
          cur.next = null;
        }

        if(cur.left != null) {
          levelOrder.add(cur.left);
        }
        if(cur.right != null) {
          levelOrder.add(cur.right);
        }
      }
    }
  }

  public void connectWithoutSpace(TreeLinkNode root) {
    /*把层次遍历修改一下，就是下面的解法了，我们使用2个循环，
    一个指针P1专门记录每一层的最左边节点，另一个指针P2扫描本层，把下一层的链接上。

    下层链接完成后，将P1移动到它的左孩子即可。

    这个算法的空间复杂度是O(1). 没有额外的空间。


    Tree like following
       2
     1  3
       4 5
    */
    if(root == null) {
      return;
    }

    TreeLinkNode leftAtLevel = root;

    while (leftAtLevel != null) {
      TreeLinkNode currentLevelNode = leftAtLevel;
      TreeLinkNode nextLevelPre = null;
      TreeLinkNode nextLevelStart = null;

      while (currentLevelNode != null) {
        if(nextLevelStart == null) {
          nextLevelStart = currentLevelNode.left != null ? currentLevelNode.left : currentLevelNode.right;
        }

        //attach next level left
        if(currentLevelNode.left != null) {
          if(nextLevelPre != null) {
            nextLevelPre.next = currentLevelNode.left;
            nextLevelPre = nextLevelPre.next;
          } else {
            nextLevelPre = currentLevelNode.left;
          }
        }

        if(currentLevelNode.right != null) {
          if(nextLevelPre != null) {
            nextLevelPre.next = currentLevelNode.right;
            nextLevelPre = nextLevelPre.next;
          } else {
            nextLevelPre = currentLevelNode.right;
          }
        }

        currentLevelNode = currentLevelNode.next;
      }

      //levelIterator moved to last, move left to next level
     leftAtLevel = nextLevelStart;
    }
  }
}
