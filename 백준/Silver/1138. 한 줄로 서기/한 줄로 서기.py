import sys


def input(): return sys.stdin.readline().strip()


n = int(input())

arr = list(map(int, input().split()))
result = [0] * n

for idx, ele in enumerate(arr, start=1):
    cur = 0
    cnt = 0

    while cnt < len(arr):
        if cnt == ele and result[cur] == 0:
            result[cur] = idx
            break
        if result[cur] == 0:
            cnt += 1
        cur += 1


print(*result)