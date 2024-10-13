import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    S = 0
    for _ in range(int(input())):
        q, *data = input().split()
        if q == 'add':
            x = int(data[0])
            S |= 1 << x
        elif q == 'remove':
            x = int(data[0])
            S &= ~(1 << x)
        elif q == 'check':
            x = int(data[0])
            print(int(S & (1 << x) != 0))
        elif q == 'toggle':
            x = int(data[0])
            if S & (1 << x):
                S &= ~ (1 << x)
            else:
                S |= (1 << x)
        elif q == 'all':
            S = (1 << 21) - 1
        elif q == 'empty':
            S = 0