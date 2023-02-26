import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = int(input())
    for i in range(T):
        H, W, N = map(int, input().split())
        floor = N % H
        room = N // H + 1
        if floor == 0:
            floor = H
            room -= 1
        print(floor * 100 + room)


if __name__ == '__main__':
    main()