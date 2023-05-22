from bisect import bisect_right


def update(node, s, e, x, v, tree):
    if x < s or e < x:
        return
    tree[node].append(v)
    if s != e:
        m = (s + e) // 2
        update(node * 2, s, m, x, v, tree)
        update(node * 2 + 1, m + 1, e, x, v, tree)


def query(node, s, e, l, r, k, tree):
    if r < s or e < l:
        return 0
    if l <= s and e <= r:
        return len(tree[node]) - bisect_right(tree[node], k)
    m = (s + e) // 2
    return query(node * 2, s, m, l, r, k, tree) + query(node * 2 + 1, m + 1, e, l, r, k, tree)


def main():
    n = int(input())
    tree = [[] for _ in range(404040)]
    t = list(map(int, input().split()))
    for i in range(1, n + 1):
        update(1, 1, n, i, t, tree)

    for i in range(404040):
        tree[i].sort()

    ans = 0
    q = int(input())

    while q:
        i, j, k = map(int, input().split())
        a = i ^ ans
        b = j ^ ans
        c = k ^ ans
        ans = query(1, 1, n, a, b, c, tree)
        print(ans)
        q -= 1


if __name__ == '__main__':
    main()
