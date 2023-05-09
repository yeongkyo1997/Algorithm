import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        try:
            n, m = map(int, input().split())
        except:
            return

        cnt = 0
        for i in range(n, m + 1):
            num = str(i)
            if len(set(num)) == len(num):
                cnt += 1

        print(cnt)


if __name__ == '__main__':
    main()