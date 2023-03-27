import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
queue = deque()
commands = [(input().strip()).split(" ") for _ in range(N)]
for i in commands:
    if len(i) == 1:
        i.append(0)
for command, x in commands:
    if command == "push_front":
        queue.appendleft(x)
    elif command == "push_back":
        queue.append(x)
    elif command == "pop_front":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif command == "pop_back":
        if queue:
            print(queue.pop())
        else:
            print(-1)
    elif command == "size":
        print(len(queue))
    elif command == "empty":
        if queue:
            print(0)
        else:
            print(1)
    elif command == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif command == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
