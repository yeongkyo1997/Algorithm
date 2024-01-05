import sys


def input(): return sys.stdin.readline().strip()


s = 0
result = []
for _ in range(int(input())):
    command = input().split()

    if command[0] == 'add':
        s |= 1 << int(command[1])
    elif command[0] == 'remove':
        s &= ~(1 << int(command[1]))
    elif command[0] == 'check':
        if s & (1 << int(command[1])):
            print(1)
        else:
            print(0)
    elif command[0] == 'toggle':
        if s & (1 << int(command[1])):
            s &= ~(1 << int(command[1]))
        else:
            s |= (1 << int(command[1]))
    elif command[0] == 'all':
        s = (1 << 21) - 1
    elif command[0] == 'empty':
        s = 0