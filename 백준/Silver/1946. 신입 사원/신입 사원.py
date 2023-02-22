import sys

input = sys.stdin.readline

for t in range(int(input())):
    arr = []

    for i in range(int(input())):
        a, b = map(int, input().split())
        arr.append((a, b))

    arr.sort()

    tmp = arr[0][1]
    result = 1

    for a, b in arr:
        if tmp > b:
            result += 1
            tmp = b
    print(result)
