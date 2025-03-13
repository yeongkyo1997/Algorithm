import sys
from itertools import combinations

input = lambda: sys.stdin.readline().rstrip()


def solution(house, chicken):
    total = 0

    for hx, hy in house:
        min_distance = float('inf')
        for cx, cy in chicken:
            distance = abs(hx - cx) + abs(hy - cy)
            min_distance = min(min_distance, distance)
        total += min_distance

    return total


n, m = map(int, input().split())

city = [list(map(int, input().split())) for _ in range(n)]

house, chicken = [], []

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            house.append((i, j))
        if city[i][j] == 2:
            chicken.append((i, j))

chicken_list = list(combinations(chicken, m))

result = float('inf')

for i in chicken_list:
    distance = solution(house, i)
    result = min(result, distance)

print(result)