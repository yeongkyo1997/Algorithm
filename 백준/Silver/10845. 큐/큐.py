front, rear = 0, 0
q = [0] * 10000
for _ in range(int(input())):
    command = input().split()
    if command[0] == 'push':
        q[rear] = int(command[1])
        rear += 1

    elif command[0] == 'pop':
        if front != rear:
            print(q[front])
            front += 1
        else:
            print(-1)

    elif command[0] == 'size':
        print(rear - front)
    elif command[0] == 'empty':
        print(int(rear == front))

    elif command[0] == 'front':
        if rear == front:
            print(-1)
        else:
            print(q[front])
    elif command[0] == 'back':
        if rear == front:
            print(-1)
        else:
            print(q[rear - 1])