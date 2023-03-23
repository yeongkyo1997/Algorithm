import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    for i in range(n):
        rank = 1
        for j in range(n):
            if i == j:
                continue
            if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
                rank += 1
        print(rank, end=' ')


if __name__ == '__main__':
    main()