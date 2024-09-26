import sys

input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = (int(arr[start] % 2 == 0), int(arr[start] % 2 == 1))
        return

    mid = (start + end) // 2
    build(node * 2 + 1, start, mid)
    build(node * 2 + 2, mid + 1, end)

    la, lb = tree[node * 2 + 1]
    ra, rb = tree[node * 2 + 2]
    tree[node] = (la + ra, lb + rb)


def update(idx, val, node, start, end):
    if idx < start or end < idx:
        return
    
    if start == end:
        tree[node] = (int(val % 2 == 0), int(val % 2 == 1))
        return

    mid = (start + end) // 2
    update(idx, val, node * 2 + 1, start, mid)
    update(idx, val, node * 2 + 2, mid + 1, end)

    la, lb = tree[node * 2 + 1]
    ra, rb = tree[node * 2 + 2]
    tree[node] = (la + ra, lb + rb)


def query(left, right, node, start, end):
    if right < start or end < left:
        return 0, 0

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2

    la, lb = query(left, right, node * 2 + 1, start, mid)
    ra, rb = query(left, right, node * 2 + 2, mid + 1, end)
    return la + ra, lb + rb


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    tree = [(0, 0) for _ in range(4 * N)]
    build(0, 0, N - 1)
    M = int(input())

    for _ in range(M):
        q, *data = map(int, input().split())

        if q == 1:
            i, x = data
            update(i - 1, x, 0, 0, N - 1)
        elif q == 2:
            l, r = data
            print(query(l - 1, r - 1, 0, 0, N - 1)[0])
        else:
            l, r = data
            print(query(l - 1, r - 1, 0, 0, N - 1)[1])