import sys
import re


def input(): return sys.stdin.readline().strip()


n = int(input())

for _ in range(n):
    s = input()
    arr = re.split(r'X+', s)
    print(sum(sum(range(1, len(i) + 1)) for i in arr))