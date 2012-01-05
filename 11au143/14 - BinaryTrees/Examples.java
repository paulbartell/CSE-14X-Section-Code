public int numNodes() {
  numNodes(overallRoot);
}
//takes a node, and returns the number of nodes under it.
private int numNodes(IntTreeNode node) {
  if(node == null)
    return 0;
  int leftside  = numNodes(node.left);
  int rightside = numNodes(node.right);
  int total     = leftside + rightside + 1;

  return total;
}


public int numLeaves() {
  numNodes(overallRoot);
}
//takes a node, and returns the number of nodes under it.
private int numLeaves(IntTreeNode node) {
  // if(node == null)
  //   return 0;
  if(node.left == null && node.right == null)
    return 1;
  int leftside  = numNodes(node.left);
  int rightside = numNodes(node.right);
  int total     = leftside + rightside;

  return total;
}



public int numLeft() {
  numleft(overallRoot);
}
//takes a node, and returns the number of nodes under it.
private int numLeft(IntTreeNode node) {
  if(node == null)
    return 0;
  //if only we knew the number of left leaves
  //in the left and right sides! then this problem
  //would be so easy.... height is the same way...
  int leftside  = numLeft(node.left);
  int rightside = numLeft(node.right);

  int total     = leftside + rightside;

  if(node.left != null)
    total++;

  return total;
}


public int height() {
  height(overallRoot);
}
private int height(IntTreeNode node) {
  if(node == null)
    return 0;

  int heightLeft = height(node.left);
  int heightRight = height(node.right);
  return Math.max(heightLeft, heightRight) + 1;
}

public boolean hasPathSum(int n) {
  hasPathSum(overallRoot, n);
}
public boolean hasPathSum(IntTreeNode node, int n) {
  //the easiest cases ever
  if(node == null)
    return false;
  if(node.data == n) {
    return true;
  }
  return hasPathSum(node.left, n - node.data) || hasPathSum(node.right, n - node.data);
  //the recursive case... we only have those three things
}


