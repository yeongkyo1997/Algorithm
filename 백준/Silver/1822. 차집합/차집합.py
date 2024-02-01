import sys


def input(): return sys.stdin.readline().rstrip()


n_a, n_b = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
result = set(a) - set(b)

if result:
    print(len(result))
    print(*sorted(result))
else:
    print(0)