from collections import deque
import sys


def input(): return sys.stdin.readline().rstrip()


q = deque()

for _ in range(int(input())):
    a = input().split()
    if a[0] == '1':
        q.appendleft(a[1])
    elif a[0] == '2':
        q.append(a[1])
    elif a[0] == '3':
        print(q.popleft() if q else '-1')
    elif a[0] == '4':
        print(q.pop() if q else '-1')
    elif a[0] == '5':
        print(len(q))
    elif a[0] == '6':
        print(int(not q))
    elif a[0] == '7':
        print(q[0] if q else '-1')
    elif a[0] == '8':
        print(q[-1] if q else '-1')