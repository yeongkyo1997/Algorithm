import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n, m = map(int, input().split())
    q = list(map(int, input().split()))
    q = [(i, idx) for idx, i in enumerate(q)]
    cnt = 0
    while True:
        if q[0][0] == max(q, key=lambda x: x[0])[0]:
            cnt += 1
            if q[0][1] == m:
                print(cnt)
                break
            else:
                q.pop(0)
        else:
            q.append(q.pop(0))