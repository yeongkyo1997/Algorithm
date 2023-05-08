import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    global result

    for i in range(n):
        a, b = map(int, input().split())
        result += b % a


if __name__ == '__main__':
    n = int(input())
    result = 0
    main()
    print(result)