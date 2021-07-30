T = int(input())  # number of Test case

for test_case in range(1, T + 1):
    k = int(input())  # k-th lexicographical order
    s = input()  # string s
    subs = set()

    # Big-O : O(N^2)
    for start in range(0, len(s)):
        for gap in range(1, len(s) + 1):
            if start + gap <= len(s):
                subs.add(s[start: start + gap])

    subs = sorted(subs)

    # when the k-th string doesnt exist
    if k <= 0 or k > len(subs):
        print(f'#{test_case} none')
    else:
        print(f'#{test_case} {subs[k-1]}')
