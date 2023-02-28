import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        N = input()
        if N == '0':
            break

        if N == N[::-1]:
            print('yes')
        else:
            print('no')


if __name__ == '__main__':
    main()
