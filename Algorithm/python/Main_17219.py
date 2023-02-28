import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    dic = {}
    for _ in range(n):
        site, pw = input().split()
        dic[site] = pw
    for _ in range(m):
        print(dic[input()])


if __name__ == '__main__':
    main()
