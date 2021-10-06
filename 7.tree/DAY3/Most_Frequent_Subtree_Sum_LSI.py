from typing import Optional, List, Union
from collections import defaultdict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        subsum_dict = defaultdict(int)

        def sum_of_tree_from_root(root: Optional[TreeNode]) -> Union[int, None]:
            if not root:
                return 0

            subsum = root.val + sum_of_tree_from_root(root.right) + sum_of_tree_from_root(root.left)
            subsum_dict[subsum] += 1

            return subsum

        sum_of_tree_from_root(root)
        most_common_subsum = max(subsum_dict.values())
        return [k for k, v in subsum_dict.items() if v == most_common_subsum]
