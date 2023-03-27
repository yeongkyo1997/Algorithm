import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline

N = int(input())


def recursion(s, left, right, cnt):
    if left >= right:
        return (1, cnt)
    elif s[left] != s[right]:
        return (0, cnt)
    else:
        return recursion(s, left + 1, right - 1, cnt + 1)


def isPalindrome(s):
    return recursion(s, 0, len(s) - 1, 1)


for i in range(N):
    print(*isPalindrome(input().rstrip()))
