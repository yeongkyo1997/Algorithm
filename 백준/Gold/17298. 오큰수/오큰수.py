import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
A = list(map(int, input().split()))

stack = []
result = [-1] * N
for i in range(N):
    if not stack:
        stack.append(i)
    else:
        while stack and A[stack[-1]] < A[i]:
            result[stack.pop()] = A[i]
        stack.append(i)
print(*result)