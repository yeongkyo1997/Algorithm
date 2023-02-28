import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = []

    for i in range(N):
        arr.append(list(map(int, input().split())))

    arr.sort(key=lambda x: (x[0], x[1]))

    for i in arr:
        print(i[0], i[1])

if __name__ == '__main__':
    main()
