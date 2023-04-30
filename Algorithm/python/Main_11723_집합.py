import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

S = set()
for _ in range(int(input())):
    tmp = input().split()

    if len(tmp) == 1:
        if tmp[0] == "all":
            S = set([i for i in range(1, 21)])
        else:
            S = set()

    else:
        com, x = tmp[0], tmp[1]
        x = int(x)

        if com == "add":
            S.add(x)
        elif com == "remove":
            S.discard(x)
        elif com == "check":
            print(1 if x in S else 0)
        elif com == "toggle":
            if x in S:
                S.discard(x)
            else:
                S.add(x)
