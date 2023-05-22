MOD = 1000000007

def multiple(a, b):
    n = len(a)
    c = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            for k in range(n):
                c[i][j] += a[i][k] * b[k][j]
                c[i][j] %= MOD
                
    return c

def matpow(a, b):
    n = len(a)
    ret = [[0] * n for _ in range(n)]

    for i in range(n):
        ret[i][i] = 1

    while b:
        if b & 1:
            ret = multiple(a, ret)
        a = multiple(a, a)
        b >>= 1

    return ret

def main():
    p, n, d = map(int, input().split())
    maps = []

    for _ in range(p):
        m = int(input())
        mat = [[0] * n for _ in range(n)]
        
        for _ in range(m):
            u, v, c = map(int, input().split())
            mat[u - 1][v - 1] = c

        maps.append(mat)

    q = [[0] * n for _ in range(n)]
    r = [[0] * n for _ in range(n)]

    for i in range(n):
        q[i][i] = 1
        r[i][i] = 1

    for mat in maps:
        q = multiple(q, mat)

    q = matpow(q, d // p)
    rr = d % p

    for i in range(rr):
        r = multiple(r, maps[i])

    q = multiple(q, r)

    for i in range(n):
        print(' '.join(str(x) for x in q[i]))

if __name__ == "__main__":
    main()