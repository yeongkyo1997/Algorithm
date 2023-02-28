import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 10999 구간 합 구하기 2
def main():
    N, M, K = map(int, input().split())
    arr = [0] * (N + 1)
    for i in range(1, N + 1):
        arr[i] = int(input())
    tree = [0] * (N * 4)
    init(arr, tree, 1, 1, N)
    for _ in range(M + K):
        a, b, c = map(int, input().split())
        if a == 1:
            diff = c - arr[b]
            arr[b] = c
            update(tree, 1, 1, N, b, diff)
        else:
            print(sum(tree, 1, 1, N, b, c))


def init(arr, tree, node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]
    mid = (start + end) // 2
    tree[node] = init(arr, tree, node * 2, start, mid) + init(arr, tree, node * 2 + 1, mid + 1, end)
    return tree[node]


def update(tree, node, start, end, index, diff):
    if index < start or index > end:
        return
    tree[node] += diff
    if start != end:
        mid = (start + end) // 2
        update(tree, node * 2, start, mid, index, diff)
        update(tree, node * 2 + 1, mid + 1, end, index, diff)


def sum(tree, node, start, end, left, right):
    if left > end or right < start:
        return 0
    if left <= start and end <= right:
        return tree[node]
    mid = (start + end) // 2
    return sum(tree, node * 2, start, mid, left, right) + sum(tree, node * 2 + 1, mid + 1, end, left, right)


if __name__ == '__main__':
    main()
