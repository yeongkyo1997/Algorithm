stack = []
for _ in range(int(input())):
    command = input().split()

    if command[0] == 'push':
        stack.append(int(command[1]))
    elif command[0] == 'pop':
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(stack))
    elif command[0] == 'empty':
        print(int(stack == []))
    elif command[0] == 'top':
        if stack:
            print(stack[-1])
        else:
            print(-1)