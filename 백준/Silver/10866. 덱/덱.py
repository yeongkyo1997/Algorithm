import sys
from collections import deque

input = lambda : sys.stdin.readline().strip()

n = int(input())
q = deque()
for _ in range(n):
    commands = input().split()
    command = commands[0]
    try:
        val = commands[1]
    except:
        pass

    if command == 'push_front':
        q.appendleft(val)
    elif command == 'push_back':
        q.append(val)
    elif command == 'pop_front':
        print(q.popleft() if q else -1)
    elif command == 'pop_back':
        print(q.pop() if q else -1)
    elif command == 'size':
        print(len(q))
    elif command == 'empty':
        print(int(bool(not q)))
    elif command == 'front':
        print(q[0] if q else -1)
    else:
        print(q[-1] if q else -1)