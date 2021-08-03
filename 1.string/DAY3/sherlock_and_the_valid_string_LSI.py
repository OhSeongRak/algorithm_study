import os
from collections import Counter


# return string => YES or NO
def isValid(s: str) -> str:
    freq = Counter(Counter(s).values())

    # in string s, characters appear the same number of times (s="aabbccdd")
    if len(freq) == 1:
        return "YES"
    # string s has over 2 characters that occur at different times (s="aaabbc")
    if len(freq) > 2:
        return "NO"
    # string contains only one character with the lowest frequency (s="aabbc")
    if freq[min(freq.keys())] == 1:
        return "YES"
    # string contains only one character with the highest frequency (s="aabc")
    if freq[max(freq.keys())] == 1 and max(freq.keys()) - 1 == min(freq.keys()):
        return "YES"

    return "NO"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = isValid(s)

    fptr.write(result + '\n')

    fptr.close()
