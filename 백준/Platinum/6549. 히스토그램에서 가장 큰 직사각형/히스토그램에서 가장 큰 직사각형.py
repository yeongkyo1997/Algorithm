import sys

sys.setrecursionlimit(10 ** 5)

while True:
    n, *arr = map(int, input().split())

    if n == 0:
        break

    stack = []
    result = 0

    for i in range(n):
        while stack and arr[i] < arr[stack[-1]]:
            h = arr[stack.pop()]
            w = i if not stack else i - stack[-1] - 1
            result = max(result, h * w)

        stack.append(i)

    while stack:
        h = arr[stack.pop()]
        w = n if not stack else n - stack[-1] - 1
        result = max(result, h * w)

    print(result)