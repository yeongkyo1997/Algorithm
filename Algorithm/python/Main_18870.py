import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = list(map(int, input().split()))
    dic = {}
    for i, v in enumerate(sorted(set(arr))):
        dic[v] = i
    print(' '.join(map(str, [dic[v] for v in arr])))


if __name__ == '__main__':
    main()
