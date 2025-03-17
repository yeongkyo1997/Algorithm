import sys

input = lambda: sys.stdin.readline().rstrip()


N, K = map(int, input().split())
num = list(map(int, input()))
stack = []
idx = 0
while True:
    if not stack:
        stack.append(num[idx])
    else:
        while stack and stack[-1] < num[idx] and K > 0:
            stack.pop()
            K -= 1
        stack.append(num[idx])

    if K == 0:
        break
    idx += 1
    if idx >= len(num):
        break

idx += 1
while idx < len(num):
    stack.append(num[idx])
    idx += 1

if K == 0:
    print("".join(map(str, stack)))
else:
    print("".join(map(str, stack[:-K])))
