import sys
import itertools

input = lambda: sys.stdin.readline().rstrip()


target = int(input())
n = int(input())
broken = set(map(int, input().split()))

min_count = abs(100 - target)

nums = [str(i) for i in range(0, 10) if i not in broken]
subset = []
for i in range(1, 7):
    for j in itertools.product(nums, repeat=i):
        subset.append("".join(j))


for i in subset:
    i = str(i)

    for j in range(len(i)):
        if int(i[j]) in broken:
            break

        elif j == len(i) - 1:
            min_count = min(min_count, abs(int(i) - target) + len(i))

print(min_count)
