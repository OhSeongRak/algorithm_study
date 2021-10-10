from typing import Optional


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:
    def serialize(self, root: Optional[TreeNode]):
        traversal = []

        def preorder(node: Optional[TreeNode]):
            if node is None:
                traversal.append('_')
            else:
                traversal.append(str(node.val))
                preorder(node.left)
                preorder(node.right)

        preorder(root)
        return ' '.join(traversal)

    def deserialize(self, data: str):
        def make_binary_tree():
            x = next(char)
            if x == '_':
                return None

            node = TreeNode(int(x))
            node.left = make_binary_tree()
            node.right = make_binary_tree()
            return node

        char = iter(data.split())
        return make_binary_tree()


ser = Codec()
deser = Codec()
ans = deser.deserialize(ser.serialize(root))
