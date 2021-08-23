from typing import *


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for asteroid in asteroids:
            # positive, asteroids moves to right
            if asteroid > 0:
                stack.append(asteroid)
            else:  # negative, asteroids moves to left
                while stack and 0 < stack[-1] < -asteroid:
                    stack.pop()

                if not stack or stack[-1] < 0:
                    stack.append(asteroid)
                elif stack[-1] == -asteroid:
                    stack.pop()

        return stack
