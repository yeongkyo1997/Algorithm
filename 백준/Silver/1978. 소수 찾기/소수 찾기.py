import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


n = int(input())
arr = list(map(int, input().split()))
cnt = 0
for i in arr:
    if is_prime(i):
        cnt += 1
print(cnt)