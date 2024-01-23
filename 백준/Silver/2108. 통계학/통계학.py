from collections import defaultdict


N = int(input())
arr = [int(input()) for _ in range(N)]
arr.sort()
print(round(sum(arr) / len(arr)))
print(arr[N // 2])

lib = defaultdict(int)

for i in arr:
    lib[i] += 1

max_val = max(lib.values())

max_list = []

for key, val in lib.items():
    if val == max_val:
        max_list.append(key)

if len(max_list) >= 2:
    print(max_list[1])
else:
    print(max_list[0])

print(max(arr) - min(arr))