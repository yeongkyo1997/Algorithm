import sys
from itertools import combinations


def input(): return sys.stdin.readline().rstrip()


while True:
    arr = list(map(int, input().split()))
    if arr[0] == 0:
        break

    k, arr = arr[0], arr[1:]

    for i in combinations(arr, 6):
        print(*i)
    print()