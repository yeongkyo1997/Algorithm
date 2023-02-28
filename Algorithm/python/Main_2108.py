import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())

    arr = []

    for i in range(N):
        arr.append(int(input()))

    print(round(sum(arr) / len(arr)))

    arr.sort()
    print(arr[N // 2])

    cnt = collections.Counter(arr).most_common(2)
    if len(arr) > 1:
        if cnt[0][1] == cnt[1][1]:
            print(cnt[1][0])
        else:
            print(cnt[0][0])
    else:
        print(cnt[0][0])

    print(max(arr) - min(arr))


if __name__ == '__main__':
    main()
