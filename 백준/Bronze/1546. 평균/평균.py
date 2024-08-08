import statistics

N = int(input())
arr = list(map(int, input().split()))

max_val = max(arr)
arr = list(map(lambda x: x / max_val * 100, arr))
print(statistics.mean(arr))