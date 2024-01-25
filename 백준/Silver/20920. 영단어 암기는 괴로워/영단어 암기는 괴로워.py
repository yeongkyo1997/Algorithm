from collections import Counter
import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
arr = list(filter(lambda x: len(x) >= M, [input() for _ in range(N)]))
cnt = Counter(arr)
print(*sorted(set(arr), key=lambda x: (-cnt[x], -len(x), x)), sep='\n')