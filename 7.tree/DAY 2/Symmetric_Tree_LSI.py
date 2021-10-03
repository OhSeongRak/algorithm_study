from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # BFS
        queue = deque([(root.left, root.right)])
        while queue:
            l_node, r_node = queue.popleft()
            if not l_node and not r_node:
                continue
            if not l_node or not r_node:
                return False
            if l_node.val != r_node.val:
                return False
            queue.append((l_node.left, r_node.right))
            queue.append((l_node.right, r_node.left))
        return True
