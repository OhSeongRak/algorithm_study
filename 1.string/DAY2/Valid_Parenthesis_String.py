class Solution:
    def checkValidString(self, s: str) -> bool:
        left, asterisk = [], []  # each list contains '(' and '*'

        for pos, char in enumerate(s):
            if char == '(':
                left.append(pos)
            elif char == '*':
                asterisk.append(pos)
            else:  # char == ')'
                if left:
                    left.pop()
                elif asterisk:
                    asterisk.pop()
                else:
                    return False

        # pop until either list is empty
        # '(' > '*' : False, '(' < '' : True
        while left and asterisk:
            if left.pop() > asterisk.pop():  # if left deque is empty
                return False

        return len(left) == 0
     
