from collections import Counter
import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr = [int(input()) for _ in range(N)]
lib_cnt = Counter(arr)

result = sorted(lib_cnt.items(), key=lambda x: (-x[1], x[0]))
print(result[0][0])