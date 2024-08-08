import sys

input = lambda: sys.stdin.readline().rstrip()
K = int(input())
stack = []

for _ in range(K):
    n = int(input())
    if n == 0:
        stack.pop()
    else:
        stack.append(n)

print(sum(stack))