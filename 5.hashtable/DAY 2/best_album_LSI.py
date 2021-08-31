from collections import defaultdict, Counter
import heapq


def solution(genres, plays):
    genre = defaultdict(int)
    answer = []

    # number of plays by genre
    for g, p in zip(genres, plays):
        genre[g] += p

    common_genre = Counter(genre).most_common()

    for k, _ in common_genre:
        heap, count = [], 0
        for i, (g, p) in enumerate(zip(genres, plays)):
            if g == k:
                heapq.heappush(heap, (-p, i))

        while heap and count < 2:
            answer.append(heapq.heappop(heap)[1])
            count += 1

    return answer
