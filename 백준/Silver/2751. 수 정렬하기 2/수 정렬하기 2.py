import random
import sys

input = lambda: sys.stdin.readline().rstrip()


def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot_idx = random.randint(0, len(arr) - 1)
    pivot = arr[pivot_idx]

    left = [x for x in arr if pivot > x]
    mid = [x for x in arr if pivot == x]
    right = [x for x in arr if pivot < x]

    return quick_sort(left) + mid + quick_sort(right)


if __name__ == '__main__':
    N = int(input())
    arr = [int(input()) for _ in range(N)]

    arr = quick_sort(arr)
    print(*arr)