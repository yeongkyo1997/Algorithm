import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        dic = {}
        for _ in range(n):
            name, category = input().split()
            if category in dic:
                dic[category] += 1
            else:
                dic[category] = 1
        result = 1
        for key in dic:
            result *= dic[key] + 1
        print(result - 1)


if __name__ == '__main__':
    main()
