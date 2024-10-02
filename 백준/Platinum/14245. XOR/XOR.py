import sys


input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return

    mid = start + end >> 1
    build(node * 2, start, mid)
    build(node * 2 + 1, mid + 1, end)
    tree[node] = tree[node * 2] ^ tree[node * 2 + 1]


def propagation(node, start, end):
    if lazy[node] != 0:
        tree[node] ^= lazy[node] * (end - start + 1)

        if start != end:
            lazy[node * 2] ^= lazy[node]
            lazy[node * 2 + 1] ^= lazy[node]

        lazy[node] = 0


def update(left, right, val, node, start, end):
    propagation(node, start, end)

    if right < start or end < left:
        return

    if left <= start and end <= right:
        tree[node] ^= val * (end - start + 1)

        if start != end:
            lazy[node * 2] ^= val
            lazy[node * 2 + 1] ^= val
        return

    mid = start + end >> 1
    update(left, right, val, node * 2, start, mid)
    update(left, right, val, node * 2 + 1, mid + 1, end)
    tree[node] = tree[node * 2] ^ tree[node * 2 + 1]


def query(left, right, node, start, end):
    propagation(node, start, end)

    if right < start or end < left:
        return 0

    if left <= start and end <= right:
        return tree[node]

    mid = start + end >> 1

    return query(left, right, node * 2, start, mid) ^ query(left, right, node * 2 + 1, mid + 1, end)


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    tree = [0] * (4 * N)
    lazy = [0] * (4 * N)
    build(1, 0, N - 1)
    M = int(input())

    for _ in range(M):
        q, *data = map(int, input().split())

        if q == 1:
            a, b, c = data
            update(a, b, c, 1, 0, N - 1)
        else:
            a = data[0]
            print(query(a, a, 1, 0, N - 1))