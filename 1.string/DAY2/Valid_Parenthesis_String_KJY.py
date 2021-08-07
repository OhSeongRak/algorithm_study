class Solution:
    def checkValidString(self, s: str) -> bool:

        # 빈 스택
        stack = []
        # 마지막 인덱스 변수
        last_index = -1
        # 문자열 s 순회
        for i in range(0, len(s)):
            if s[i] == '(':
                stack.append('(')
                last_index += 1

            elif s[i] == '*':
                stack.append('*')
                last_index += 1
            # ')'
            else:
                # 스택아무것도 없음
                if len(stack) == 0:
                    return False
                # 스택 마지막 친구가 ( 이면 퉁치기
                if stack[last_index] == '(':
                    del stack[last_index]
                    last_index -= 1

                # 스택 마지막 친구가 별이면 index 자신 부터 0으로 가면서 ( <- 검사  있으면 개랑 퉁치고 없으면 *이랑 퉁치기!!!
                elif stack[last_index] == '*':
                    # j 는 last_index 부터 0까지 돔
                    flag = 0
                    for j in range(last_index, -1, -1):  # 1 에서 멈춤    for i  in range (0,n+1)  =
                        if stack[j] == '(':
                            del stack[j]
                            last_index -= 1
                            flag = 1
                            break
                    if flag == 0:
                        del stack[last_index]
                        last_index -= 1
                else:
                    print('스택에 ) 가 있는 경우는 없음')

        new_stack = []
        last_index = -1

        for i in range(0, len(stack)):
            if stack[i] == '(':
                new_stack.append('(')
                last_index += 1
            else:
                if last_index != -1 and new_stack[last_index] == '(':
                    del new_stack[last_index]
                    last_index -= 1

        for j in range(0, len(new_stack)):
            if new_stack[j] == '(':
                return False
        return True