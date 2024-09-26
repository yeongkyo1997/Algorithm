import math
import sys


input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = (data[start], data[start])
    else:
        mid = (start + end) // 2

        # 왼쪽 생성
        build(node * 2 + 1, start, mid)

        # 오른쪽 생성
        build(node * 2 + 2, mid + 1, end)

        # 값 지정
        tree[node] = (
            min(tree[node * 2 + 1][0], tree[node * 2 + 2][0]), max(tree[node * 2 + 1][1], tree[node * 2 + 2][1]))


def query(left, right, node, start, end):
    if left > end or right < start:
        return (math.inf, -math.inf)

    if left <= start and right >= end:
        return tree[node]

    mid = (start + end) // 2
    left_val = query(left, right, node * 2 + 1, start, mid)
    right_val = query(left, right, node * 2 + 2, mid + 1, end)

    return min(left_val[0], right_val[0]), max(left_val[1], right_val[1])


if __name__ == '__main__':
    N, M = map(int, input().split())
    data = [int(input()) for _ in range(N)]
    tree = [(math.inf, -math.inf) for _ in range(4 * N)]
    build(0, 0, len(data) - 1)

    for _ in range(M):
        a, b = map(int, input().split())
        print(*query(a - 1, b - 1, 0, 0, len(data) - 1))