import statistics

N = int(input())

arr = [int(input()) for _ in range(N)]

arr.sort()

print(round(statistics.mean(arr)))
print(statistics.median(arr))
mode = statistics.multimode(arr)
if len(mode) >= 2:
    print(mode[1])
else:
    print(mode[0])
print(arr[-1] - arr[0])
