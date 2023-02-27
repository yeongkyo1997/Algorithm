import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    meetings = [list(map(int, input().split())) for _ in range(n)]
    meetings.sort(key=lambda x: (x[1], x[0]))
    cnt = 0
    end = 0
    for meeting in meetings:
        if end <= meeting[0]:
            end = meeting[1]
            cnt += 1
    print(cnt)


if __name__ == '__main__':
    main()