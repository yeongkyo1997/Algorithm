input = __import__('sys').stdin.readline
mis = lambda: map(int, input().split())
ii = lambda: int(input())

N, k = mis()
arr = list(mis())
print(sum(arr) - N * arr[0], N - arr.count(arr[0]))
