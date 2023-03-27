import sys
from itertools import combinations

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

chicken = []
house = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append((i, j))
        elif arr[i][j] == 2:
            chicken.append((i, j))


def get_distance(house, chicken):
    result = 0

    for hx, hy in house:
        temp = 1e9

        for cx, cy in chicken:
            temp = min(temp, abs(hx - cx) + abs(hy - cy))

        result += temp

    return result


result = 1e9

for comb in combinations(chicken, M):
    result = min(result, get_distance(house, comb))

print(result)
