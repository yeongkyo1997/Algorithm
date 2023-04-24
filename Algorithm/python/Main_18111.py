import math
import sys

input = lambda: sys.stdin.readline().rstrip()

N, M, B = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

rTime = math.inf
rHeight = 0

for k in range(257):
    time = 0
    block = B
    for i in range(N):
        for j in range(M):
            if arr[i][j] > k:
                time += 2 * (arr[i][j] - k)
                block += arr[i][j] - k
            elif arr[i][j] < k:
                time += k - arr[i][j]
                block -= k - arr[i][j]
    if block >= 0 and time <= rTime:
        rTime = time
        rHeight = k

print(rTime, rHeight)
