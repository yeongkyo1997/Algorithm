import sys

input = sys.stdin.readline

for t in range(int(input())):
    arr = []

    for i in range(int(input())):
        arr, b = map(int, input().split())
        arr.append((arr, b))

    arr.sort()

    tmp = arr[0][1]
    result = 1

    for arr, b in arr:
        if tmp > b:
            result += 1
            tmp = b
    print(result)
