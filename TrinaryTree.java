class TrinaryNode {
int key;
TrinaryNode left;
TrinaryNode middle;
TrinaryNode right;

public TrinaryNode(int key) {
this.key = key;
this.left = this.middle = this.right = null;
}

}


class TrinaryTree {
TrinaryNode root;

//Construct an empty TrinaryTree at first
public TrinaryTree() {
root = null;
}

/* Insert node */

public TrinaryNode insert(key, node) {
if (node == null) {
node = new TrinaryNode(key);
} else if (key < node.key) {
node.left = insert(key, node.left);
} else if (key == node.key) {
node.middle = insert(key, node.middle) ;
} else {
node.right = insert(key, node.right);
}
return node;
}

/* Find the min node */

public TrinaryNode findMin(node) {
if (node != null) {
while (node.left != null) {
return findMin(node.left);
}
}
return node;
}

/* Delete node */
public TrinaryNode delete(key, node) {
if (node == null) {
throw new RuntimeException();
} else if (key < node.key) {
node.left = delete(key, node.left);
} else if (key > node.key) {
node.right = delete(key, node.right);
} else {
if (node.middle != null) {
node.middle = delete(key, node.middle);
} else if (node.right != null) {
node.key = findMin(node.right).key;
node.right = delete(findMin(node.right).key, node.right);
} else {
node = node.left;
}
}
return node;
}
}


