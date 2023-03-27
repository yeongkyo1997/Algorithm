import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

t = int(input())
for i in range(1, t + 1):
    arr, b, N = map(int, input().split())
    prime = []
    divide = []
    M = collections.defaultdict(int)
    flag = 1

    while N > 1:
        flag = 1
        for i in prime:
            if N % i == 0:
                N //= i
                flag = 0
                M[i] = 1
                break

        if flag:
            break

    if N != 1:
        M[N] = 1

    for i in M:
        divide.append(i)

    result = 0
    bit = 1 << len(divide)

    for i in range(1, bit):
        cnt = 0
        sum = 1

        for j in range(len(divide)):
            if not (i & (1 << j)):
                continue

            cnt += 1
            sum *= divide[j]

        aa = (arr + sum - 1) // sum
        bb = b // sum

        if aa > bb:
            continue

        if cnt & 1:
            result += bb - aa + 1
        else:
            result -= bb - aa + 1
    print(f"Case #{i}: {b - arr + 1 - result}")
