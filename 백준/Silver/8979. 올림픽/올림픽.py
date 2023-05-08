import sys

input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
arr = []

for _ in range(N):
    arr.append(list(map(int, input().split())))

arr.sort(key=lambda x: (-x[1], -x[2], -x[3]))
rank = 1

for i in range(N):
    if arr[i][0] == K:
        for j in range(i):
            if arr[i][1:] == arr[j][1:]:
                rank -= 1
                break
        break
    else:
        if arr[i][1:] == arr[i - 1][1:]:
            pass
        else:
            rank += 1
print(rank)