from typing import List
from collections import Counter, deque, defaultdict


def solution(begin, target, words):
    if target not in words:
        return 0

    def next_words(cur_word: str, words: List[str]):
        for word in words:
            if len(Counter(cur_word) - Counter(word)) == 1:
                yield word

    # BFS
    queue, visited = deque([begin]), defaultdict(int)
    while queue:
        cur_word = queue.popleft()
        for next_word in next_words(cur_word, words):
            if not visited[next_word]:
                visited[next_word] = visited[cur_word] + 1
                queue.append(next_word)

    return visited[target]
