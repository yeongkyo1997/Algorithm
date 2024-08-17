import statistics

N = int(input())
arr = map(int, input().rstrip().split())
print(statistics.median(arr))
