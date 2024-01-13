import statistics
import sys


def input(): return sys.stdin.readline().rstrip()


c = int(input())

for i in range(c):
    N, *arr = list(map(int, input().split()))
    mean = statistics.mean(arr)
    print(f'{len(list(filter(lambda x: x > mean, arr))) * 100 / N}%')