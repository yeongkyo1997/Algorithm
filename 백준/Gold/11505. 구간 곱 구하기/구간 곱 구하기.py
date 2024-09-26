import sys


input = lambda: sys.stdin.readline().rstrip()


# 세그먼트 트리 구성
def build(node, start, end):
    # 단말 노드
    if start == end:
        tree[node] = data[start]
    else:
        mid = (start + end) // 2

        # 왼쪽 생성
        build(node * 2 + 1, start, mid)

        # 오른쪽 생성
        build(node * 2 + 2, mid + 1, end)

        # 현재 노드에 값을 부여
        tree[node] = (tree[node * 2 + 1] * tree[node * 2 + 2]) % MOD


# 세그먼트 트리 업데이트
def update(idx, val, node, start, end):
    if start == end:
        tree[node] = val
    else:
        mid = (start + end) // 2

        # 왼쪽의 경우
        if start <= idx <= mid:
            update(idx, val, node * 2 + 1, start, mid)
        else:
            update(idx, val, node * 2 + 2, mid + 1, end)

        # 현재 노드 업데이트
        tree[node] = (tree[node * 2 + 1] * tree[node * 2 + 2]) % MOD


# 구간합
def query(left, right, node, start, end):
    # 구간합 밖이라면
    if start > right or end < left:
        return 1

    # 구간이 완전히 속한다면
    if start >= left and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return (query(left, right, node * 2 + 1, start, mid) * query(left, right, node * 2 + 2, mid + 1, end)) % MOD


if __name__ == '__main__':
    MOD = 1_000_000_007
    N, M, K = map(int, input().split())
    data = [int(input()) for _ in range(N)]
    tree = [0] * (len(data) * 4)
    build(0, 0, len(data) - 1)

    for _ in range(M + K):
        a, b, c = map(int, input().split())
        if a == 1:
            update(b - 1, c, 0, 0, len(data) - 1)
        elif a == 2:
            print(query(b - 1, c - 1, 0, 0, len(data) - 1))