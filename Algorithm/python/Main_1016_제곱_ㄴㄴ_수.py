import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

min, max = map(int, input().split())
number = [0] * (max - min + 1)
cnt = 0
for i in range(2, int(max ** 0.5) + 1):
    N = min // (i * i)
    if min % (i * i): N += 1
    while N * i * i <= max:
        number[N * i * i - min] = 1
        N += 1
for i in range(max - min + 1):
    if number[i] == 0: cnt += 1
print(cnt)
