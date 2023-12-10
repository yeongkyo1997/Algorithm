import re
import sys

input = lambda: sys.stdin.readline().rstrip()


def solution(arr):
    pattern = re.compile("(100+1+|01)+")

    results = []
    for case in arr:
        if pattern.fullmatch(case):
            results.append("YES")
        else:
            results.append("NO")

    return results


t = int(input())

arr = []
for _ in range(t):
    arr.append(input())

print(*solution(arr), sep="\n")