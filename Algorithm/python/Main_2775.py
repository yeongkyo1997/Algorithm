import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = int(input())
    for i in range(T):
        k = int(input())
        n = int(input())
        arr = [i for i in range(1, n + 1)]
        for j in range(k):
            for l in range(1, n):
                arr[l] += arr[l - 1]
        print(arr[-1])


if __name__ == '__main__':
    main()
