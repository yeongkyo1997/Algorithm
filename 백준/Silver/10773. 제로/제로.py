import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    k = int(input())
    arr = []
    for _ in range(k):
        n = int(input())
        if n == 0:
            arr.pop()
        else:
            arr.append(n)
    print(sum(arr))


if __name__ == '__main__':
    main()