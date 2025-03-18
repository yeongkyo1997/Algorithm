import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

result = 0
if N % 5 == 0:
    result = N // 5
else:
    while N > 0:
        N -= 3
        result += 1

        if N % 5 == 0:
            result += N // 5
            break
        if N < 3:
            result = -1

print(result)
