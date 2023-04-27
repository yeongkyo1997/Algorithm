import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
trees = list(map(int, input().split()))


def isPossible(height):
    taken = 0
    for i in range(N):
        if trees[i] >= height:
            taken += (trees[i] - height)
        if taken >= M:
            return True
    return False


def solve():
    left = 0
    right = 1000000000
    while left <= right:
        mid = (left + right) // 2
        if isPossible(mid):
            ret = mid
            left = mid + 1
        else:
            right = mid - 1
    return ret


print(solve())