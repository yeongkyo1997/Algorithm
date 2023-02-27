import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    H, M = map(int, input().split())
    if M >= 45:
        print(H, M - 45)
    else:
        if H == 0:
            print(23, M + 15)
        else:
            print(H - 1, M + 15)


if __name__ == '__main__':
    main()