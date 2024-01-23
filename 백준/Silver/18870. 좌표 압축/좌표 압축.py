N = int(input())
arr = list(map(int, input().split()))

sorted_arr = sorted(set(arr))

result = {val: idx for idx, val in enumerate(sorted_arr)}

for i in arr:
    print(result[i], end=' ')