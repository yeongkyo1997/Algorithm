import sys


def input(): return sys.stdin.readline().rstrip()


for _ in range(int(input())):
    T, *arr = map(int, input().split())

    result = 0
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                result += 1

    print(T, result)