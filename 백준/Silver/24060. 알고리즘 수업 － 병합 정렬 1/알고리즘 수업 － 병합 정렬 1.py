import math
import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline


def merge_sort(arr, p, r):
    if p < r:
        q = math.floor((p + r) / 2)
        merge_sort(arr, p, q)
        merge_sort(arr, q + 1, r)
        merge(arr, p, q, r)


def merge(arr, p, q, r):
    global cnt, k
    i = p
    j = q + 1
    t = 1

    while i <= q and j <= r:
        if arr[i] <= arr[j]:
            tmp[t] = arr[i]
            t += 1
            i += 1
        else:
            tmp[t] = arr[j]
            t += 1
            j += 1

    while i <= q:
        tmp[t] = arr[i]
        t += 1
        i += 1

    while j <= r:
        tmp[t] = arr[j]
        t += 1
        j += 1
    i = p
    t = 1

    while i <= r:
        arr[i] = tmp[t]
        i += 1
        t += 1
        cnt += 1
        if cnt == k:
            print(arr[i - 1])
            exit()


N, k = map(int, input().split())
arr = list(map(int, input().split()))
tmp = [0] * (N + 1)
cnt = 0

result = -1
merge_sort(arr, 0, N - 1)
print(result)
