# BOJ 18111 마인크래프트

import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m, b = map(int, input().split())
    arr = []
    for _ in range(n):
        arr.extend(list(map(int, input().split())))
    arr.sort()
    ans = 100000000000000000000
    ans_height = 0
    for i in range(arr[0], arr[-1] + 1):
        time = 0
        block = b
        for j in arr:
            if j > i:
                time += (j - i) * 2
                block += j - i
            elif j < i:
                time += i - j
                block -= i - j
        if block >= 0:
            if ans >= time:
                ans = time
                ans_height = i
    print(ans, ans_height)
    

if __name__ == '__main__':
    main()