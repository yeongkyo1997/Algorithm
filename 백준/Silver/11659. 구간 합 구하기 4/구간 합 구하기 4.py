import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = list(map(int, input().split()))

sum_arr = [0] * N
sum_arr[0] = arr[0]
for i in range(1, N):
    sum_arr[i] = arr[i] + sum_arr[i - 1]

for _ in range(M):
    a, b = map(int, input().split())
    print(sum_arr[b - 1] - sum_arr[a - 1] + arr[a - 1])