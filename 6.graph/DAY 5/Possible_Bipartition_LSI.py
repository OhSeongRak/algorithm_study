from typing import *
from collections import defaultdict, deque


# Idea from 4 color theorem
class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        planar = defaultdict(list)
        queue, label = deque(), defaultdict(int)

        for who, whom in dislikes:
            planar[who].append(whom)
            planar[whom].append(who)

        for person in range(1, n+1):
            if person not in label:
                queue.append(person)
                label[person] = 1

            # BFS
            while queue:
                cur = queue.popleft()
                for dislike in planar[cur]:
                    if dislike not in label:
                        label[dislike] = -label[cur]
                        queue.append(dislike)
                    # not possible to group by two label
                    if dislike in label and label[dislike] != -label[cur]:
                        return False

        return True


# WA
# class Solution:
#     def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
#         dislike, like = collections.defaultdict(list), collections.defaultdict(list)
#         people = [l for l in range(1, n+1)]
#         person = 1
#         stack, visited = [person], []
#
#         for who, whom in dislikes:
#             dislike[who].append(whom)
#             dislike[whom].append(who)
#
#         for i in range(1, n + 1):
#             like[i].extend([p for p in people if p != i and p not in dislike[i]])
#
#         # DFS
#         while stack:
#             cur = stack.pop()
#             for neighbor in like[cur]:
#                 if neighbor not in visited and neighbor not in dislike[person]:
#                     stack.append(neighbor)
#             visited.append(cur)
#
#         for i, p1 in enumerate(visited[1:], start=1):
#             for p2 in visited[i+1:]:
#                 if p1 in dislike[p2]:
#                     return False
#
#         others = [p for p in people if p not in visited]
#         for i, p1 in enumerate(others):
#             for p2 in others[i+1:]:
#                 if p1 in dislike[p2]:
#                     return False
#
#         return True
