from collections import deque
from typing import Optional, List


# depth recursive <=> DFS
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.view = []

    def recursiveRightSideView(self, node: Optional[TreeNode], depth: int):
        if not node:
            return

        if len(self.view) == depth:
            self.view.append(node.val)

        self.recursiveRightSideView(node.right, depth+1)
        self.recursiveRightSideView(node.left, depth+1)

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.recursiveRightSideView(root, 0)

        return self.view


# recursive method
class SecondSolution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root:
            right, left = self.rightSideView(root.right), self.rightSideView(root.left)
            return [root.val] + right + left[len(right):]
        return []


# BFS - level
class ThirdSolution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        queue, view = deque([root]), []
        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()
                val = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            view.append(val)
        return view
