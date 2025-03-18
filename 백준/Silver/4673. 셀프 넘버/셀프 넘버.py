import sys, collections
from functools import cache

sys.setrecursionlimit(100000)


input = lambda: sys.stdin.readline().rstrip()


@cache
def d(num):
    x = num + sum(map(int, list(str(num))))
    if num > 10000:
        return
    nums[x] = 0
    d(x)


nums = collections.defaultdict(lambda: 1)
for i in range(1, 10001):
    d(i)
for i in range(1, 10001):
    if nums[i] == 1:
        print(i)
