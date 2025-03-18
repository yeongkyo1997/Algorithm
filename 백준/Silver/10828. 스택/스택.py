import sys


input = lambda: sys.stdin.readline().rstrip()

N = int(input())

stack = []
result = []
for _ in range(N):
    data = input().split()
    if data[0] == "push":
        x = int(data[1])
        stack.append(x)
    elif data[0] == "pop":
        if stack:
            result.append(stack.pop())
        else:
            result.append(-1)
    elif data[0] == "size":
        result.append(len(stack))
    elif data[0] == "empty":
        result.append(int(not stack))
    else:
        if stack:
            result.append(stack[-1])
        else:
            result.append(-1)

print("\n".join(map(str, result)))
