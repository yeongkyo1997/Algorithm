import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    x = int(input())
    y = int(input())

    if x > 0 and y > 0:
        print(1)
    elif x > 0 > y:
        print(4)
    elif x < 0 and y < 0:
        print(3)
    else:
        print(2)


if __name__ == '__main__':
    main()