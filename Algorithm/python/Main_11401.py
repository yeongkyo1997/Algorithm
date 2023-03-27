import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
A = 1
for i in range(N, N - K, -1):
    A = A * i % 1000000007
B = 1
for i in range(1, K + 1):
    B = B * i % 1000000007
B = pow(B, 1000000005, 1000000007)
print(A * B % 1000000007)
