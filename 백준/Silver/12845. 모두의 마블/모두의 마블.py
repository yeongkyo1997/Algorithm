import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
result = 0

while len(arr) >= 2:
    max_value = max(arr)
    idx = arr.index(max_value)

    try:
        min_value = min(arr[idx - 1], arr[idx + 1])

        if arr[idx - 1] > arr[idx + 1]:
            idx += 1
        else:
            idx -= 1
    except:
        if idx == 0:
            min_value = arr[idx + 1]
            idx += 1
        elif idx == len(arr) - 1:
            min_value = arr[idx - 1]
            idx -= 1
    result += max_value + min_value
    del arr[idx]
print(result)
