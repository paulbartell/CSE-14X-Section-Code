public void tighten() {
  overallRoot = tighties(overallRoot)
}

private IntTreeNode tighties(IntTreeNode node) {
  if(node == null)
    return node; //null
  else if(node.left == null && node.right == null)
    return node; //we did not change anything here
  else if(node.left != null && node.right != null) {
    node.left  = tighties(node.left)
    node.right = tighties(node.right)
    return node;
  }
  else if(node.left == null && node.right != null) {
    node.left  = tighties(node.left)
    node.right = tighties(node.right)
    return node.right;
  }
  else
    node.left  = tighties(node.left)
    node.right = tighties(node.right)
    return node.left;
  }
}

public void removeLeaves() {
  overallRoot = removeLeaves(overallRoot);
}
private void removeLeaves(IntTreeNode node) {
  if(node == null)
    return null;
  else if(node.left == null && node.right == null)
    return null;
  else if(node.left == null && node.right != null) {
    node.right = removeLeaves(node.right);
    return node;
  } else if(node.left != null && node.right == null) {
    node.left = removeLeaves(node.left);
    return node;
  } else
    node.right = removeLeaves(node.right);
    node.left = removeLeaves(node.left);
    return node;
  }
}

private void removeLeaves(IntTreeNode node) {
  if(node == null)
    return null;
  if(node.left == null && node.right == null)
    return null;

  node.left  = removeLeaves(node.left);
  node.right = removeLeaves(node.right);


  return node;
}


public void completeToLevel(int n) {
  overallRoot = completeToLevel(overallRoot,n);
}

private void completeToLevel(IntTreeNode node, int n) {
  if(n < 1)
    throw new IllegalArgumentException();
  else if(node == null)
    return null;
  else if(n > 1) {
    node.left  = completeToLevel(node.left, n - 1);
    node.right = completeToLevel(node.right, n - 1);
    return node;
  } else if(node.left != null && node.right != null) {
    return node;
  } else if (node.left == null && node.right != null) {
    node.left = new IntTreeNode(-1);
    return node;
  } else if (node.left != null && node.right == null) {
    node.right = new IntTreeNode(-1);
    return node;
  }
}
