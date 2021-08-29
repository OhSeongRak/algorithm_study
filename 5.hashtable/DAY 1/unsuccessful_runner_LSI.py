from collections import Counter


def solution(participant, completion):
    fail = Counter(participant) - Counter(completion)

    return "".join(fail.keys())