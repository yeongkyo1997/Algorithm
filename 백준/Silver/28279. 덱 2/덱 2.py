import sys
from collections import deque
R=sys.stdin.readline
d=deque()
for _ in[0]*int(R()):
    c,*v=R().split()
    C=int(c)
    if C<3:d.appendleft(v[0]) if C<2 else d.append(v[0])
    elif C==3:print(d.popleft() if d else -1)
    elif C==4:print(d.pop() if d else -1)
    elif C==5:print(len(d))
    elif C==6:print(+(not d))
    elif C==7:print(d[0] if d else -1)
    else:print(d[-1] if d else -1)