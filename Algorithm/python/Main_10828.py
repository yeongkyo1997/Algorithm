import sys

input = lambda: sys.stdin.readline().rstrip()

stack = []
for _ in range(int(input())):
    arr = input().split()

    if arr[0] == 'push':
        stack.append(arr[1])
    elif arr[0] == 'pop':
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif arr[0] == 'size':
        print(len(stack))
    elif arr[0] == 'empty':
        if stack:
            print(0)
        else:
            print(1)
    else:
        if stack:
            print(stack[-1])
        else:
            print(-1)
