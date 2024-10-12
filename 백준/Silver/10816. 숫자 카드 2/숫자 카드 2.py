import sys
from bisect import bisect_left, bisect_right

input = lambda: sys.stdin.readline().rstrip()
if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    M = int(input())
    it = iter(map(int, input().split()))

    result = []
    for _ in range(M):
        x = next(it)
        result.append(bisect_right(arr, x) - bisect_left(arr, x))

    print(' '.join(map(str, result)))