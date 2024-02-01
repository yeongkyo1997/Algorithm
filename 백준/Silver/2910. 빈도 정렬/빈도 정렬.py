from collections import Counter
import sys


def input(): return sys.stdin.readline().rstrip()


N, C = map(int, input().split())

arr = list(map(int, input().split()))
lib = Counter(arr)
result = sorted(lib.items(), key=lambda x: -x[1])

for a, b in result:
    print(*[a] * b, end=' ')