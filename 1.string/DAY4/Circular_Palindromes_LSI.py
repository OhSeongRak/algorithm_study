# Time Limit Exceeded ...

# N: number of rotates
# k-lines contains an integer denoting the maximum length of any palindromic substring

# 1. string rotate => collections.deque.rotate()
# 2. Find max length palindrome of substring S => extend from center, sliding window

import collections
import os


def circularPalindromes(s: str):
    max_length_palindrome = []
    deque = collections.deque(s)

    def expand(c: str, left: int, right: int) -> str:
        while left >= 0 and right < len(c) and c[left] == c[right]:
            left -= 1
            right += 1
        return right - left - 1  # len(c[left+1:  right])

    for k in range(len(s)):
        c = ''.join(deque)

        if len(c) < 2 or c == c[::-1]:
            max_length_palindrome.append(len(c))  # .insert(k, len(c))

        else:
            max_len = 1
            for i in range(len(c) - 1):
                max_len = max(max_len,
                              expand(c, i, i + 1),
                              expand(c, i, i + 2))

            max_length_palindrome.append(max_len)  # .insert(k, max_len)

        deque.rotate(-1)

    return max_length_palindrome


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    s = input()

    result = circularPalindromes(s)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
