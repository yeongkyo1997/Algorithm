import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    dic = {}
    for i in range(1, n + 1):
        name = input()
        dic[name] = i
        dic[str(i)] = name
    for _ in range(m):
        print(dic[input()])


if __name__ == '__main__':
    main()
