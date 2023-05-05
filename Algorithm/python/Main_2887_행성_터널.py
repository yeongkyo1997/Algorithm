import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    parent = [i for i in range(N)]
    X, Y, Z = [], [], []
    info = []
    for i in range(N):
        x, y, z = map(int, input().split())
        X.append((x, i))
        Y.append((y, i))
        Z.append((z, i))

    X.sort()
    Y.sort()
    Z.sort()

    for i in range(N - 1):
        info.append((X[i + 1][0] - X[i][0], (X[i][1], X[i + 1][1])))
        info.append((Y[i + 1][0] - Y[i][0], (Y[i][1], Y[i + 1][1])))
        info.append((Z[i + 1][0] - Z[i][0], (Z[i][1], Z[i + 1][1])))

    info.sort()
    cnt = 0
    total = 0

    def find(x):
        if parent[x] == x:
            return x
        parent[x] = find(parent[x])
        return parent[x]

    def unite(a, b):
        a = find(a)
        b = find(b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

    for i in range(len(info)):
        a = info[i][1][0]
        b = info[i][1][1]
        val = info[i][0]

        if find(a) != find(b):
            unite(a, b)
            total += val

    print(total)


if __name__ == '__main__':
    main()
