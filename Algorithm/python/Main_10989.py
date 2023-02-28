import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    dict = {}

    N = int(input())
    for i in range(N):
        num = int(input())
        if num in dict:
            dict[num] += 1
        else:
            dict[num] = 1

    for i in range(1, 10001):
        if i in dict:
            for j in range(dict[i]):
                print(i)


if __name__ == '__main__':
    main()
