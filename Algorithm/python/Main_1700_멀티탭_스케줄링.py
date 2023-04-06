import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, k = map(int, input().split())
schedule = list(map(int, input().split()))
multiTap = [0] * N
result = 0

for i in range(k):
    flag = False
    for j in range(N):
        if multiTap[j] == schedule[i]:
            flag = True
            break
    if flag:
        continue
    for j in range(N):
        if multiTap[j] == 0:
            multiTap[j] = schedule[i]
            flag = True
            break
    if flag:
        continue
    last_need = -1
    index = -1
    for j in range(N):
        tmp = 0
        for t in range(i + 1, k):
            if schedule[t] == multiTap[j]:
                break
            tmp += 1
        if tmp > last_need:
            last_need = tmp
            index = j
    multiTap[index] = schedule[i]
    result += 1
print(result)
