import sys
from bisect import bisect_left, bisect_right


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr1 = sorted(map(int, input().split()))
M = int(input())
card = map(int, input().split())


for i in card:
    print(bisect_right(arr1, i) - bisect_left(arr1, i), end=' ')