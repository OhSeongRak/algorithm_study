import sys
sys.setrecursionlimit(10**9)


class TreeNode:
    def __init__(self, x, val=0, left=None, right=None):
        self.x = x
        self.val = val
        self.left = left
        self.right = right


class Tree:
    def __init__(self):
        self.root = None
        self.preorder_list = []
        self.postorder_list = []

    def insert_node(self, x, val):
        cur_node = self.root
        if self.root is None:
            self.root = TreeNode(x, val)
        else:
            while True:
                # left
                if x < cur_node.x:
                    if cur_node.left is None:
                        cur_node.left = TreeNode(x, val)
                        break
                    else:
                        cur_node = cur_node.left
                # right
                else:
                    if cur_node.right is None:
                        cur_node.right = TreeNode(x, val)
                        break
                    else:
                        cur_node = cur_node.right

    def preorder_traversal(self):
        def _preorder_traversal(root):
            if root is None:
                pass
            else:
                self.preorder_list.append(root.val)
                _preorder_traversal(root.left)
                _preorder_traversal(root.right)

        _preorder_traversal(self.root)

    def postorder_traversal(self):
        def _postorder_traversal(root):
            if root is None:
                pass
            else:
                _postorder_traversal(root.left)
                _postorder_traversal(root.right)
                self.postorder_list.append(root.val)

        _postorder_traversal(self.root)


def solution(nodeinfo):
    for i in range(len(nodeinfo)):
        nodeinfo[i].append(i + 1)

    sorted_nodeinfo, tree = sorted(nodeinfo, key=lambda x: (-x[1], x[0])), Tree()

    for x, _, val in sorted_nodeinfo:
        tree.insert_node(x, val)

    tree.preorder_traversal()
    tree.postorder_traversal()

    return [tree.preorder_list, tree.postorder_list]
