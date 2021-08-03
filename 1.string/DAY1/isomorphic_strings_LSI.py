"""
given two strings s and t, determine if they are Isomorphic.
Isomorphic strings means all occurrences of a character must be replaced with another character,
while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
"""
from lib import *


class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(zip(s, t))) == len(set(s)) == len(set(t))
