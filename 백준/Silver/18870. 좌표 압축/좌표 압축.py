import bisect

N = int(input())

arr = list(map(int, input().split()))

sorted_arr = sorted(set(arr))

for a in arr:
    print(bisect.bisect_left(sorted_arr, a), end=' ')