import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = int(input())
    while T:
        T -= 1
        n = int(input())
        str = bin(n)[2:]
        str = str[::-1]

        for idx, val in enumerate(str):
            if val == '1':
                print(idx, end=' ')
        print()


if __name__ == '__main__':
    main()