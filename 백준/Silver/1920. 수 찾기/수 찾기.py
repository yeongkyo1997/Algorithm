import bisect

N = int(input())

arr = list(map(int, input().rstrip().split()))
arr.sort()

M = int(input())


def binary_search(a, x):
    lo, hi = 0, len(a)
    pos = bisect.bisect_left(a, x, lo, hi)
    return 1 if pos != hi and a[pos] == x else 0


for ele in map(int, input().rstrip().split()):
    print(binary_search(arr, ele))