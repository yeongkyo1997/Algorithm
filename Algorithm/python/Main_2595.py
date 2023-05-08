import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

tmpi, reti = 0, 0
tmp, ret = "", ""


def isBig(a, b):
    if len(a) < len(b):
        return 1
    elif len(a) > len(b):
        return 0
    else:
        for i in range(len(a)):
            if a[i] > b[i]:
                return 0
            elif a[i] < b[i]:
                return 1

        return 1


def solve(a, b):
    global N
    cur, nxt, f = 0, 0, 0
    num = [a, b]
    bit = [0 for _ in range(N)]
    pre = [0 for _ in range(N)]
    q = []

    if a > 0:
        pre[a % N] = -1
        bit[a % N] = a
        q.append(a % N)

    pre[b % N] = -1
    bit[b % N] = b
    q.append(b % N)

    while q:
        cur = q.pop(0)

        if cur == 0:
            f = 1
            break

        for k in range(2):
            nxt = (cur * 10 + num[k]) % N

            if not pre[nxt]:
                pre[nxt] = cur
                bit[nxt] = num[k]
                q.append(nxt)

    if f == 0:
        return "-1"

    st = []

    while cur != -1:
        st.append(bit[cur])
        cur = pre[cur]

    ret = ""
    while st:
        ret += str(st.pop())

    return ret


reti = 10

for i in range(10):
    for j in range(i, 10):
        if not i and not j:
            continue

        tmp = solve(i, j)
        if tmp == "-1":
            continue

        if i == j:
            tmpi = 1
        else:
            tmpi = 2

        if tmpi < reti or (tmpi == reti and isBig(tmp, ret)):
            ret = tmp
            reti = tmpi

print(ret)
