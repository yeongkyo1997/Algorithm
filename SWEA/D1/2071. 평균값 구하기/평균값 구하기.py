import math
import statistics

for t in range(1, int(input()) + 1):
    print(f'#{t} {round(statistics.mean(map(int, input().split())))}')
