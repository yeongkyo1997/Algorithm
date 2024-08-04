import bisect

N = int(input())
arr = list(map(int, input().rstrip().split()))
arr.sort()

M = input()

for ele in map(int, input().rstrip().split()):
    print(bisect.bisect_right(arr, ele) - bisect.bisect_left(arr, ele), end=' ')