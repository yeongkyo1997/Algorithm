def main():
    limit = 1_000_000_000
    n, m = map(int, input().split())

    v = []
    cost = {}

    for _ in range(n):
        s1, c1 = input().split()
        cost[s1] = int(c1)

    for _ in range(m):
        tmp = input()
        prev = 0
        cur = tmp.find('=')
        s1 = tmp[:cur]
        prev = cur + 1

        _v = []
        while True:
            cur = tmp.find('+', prev)
            if cur == -1:
                cur = len(tmp)
            s2 = tmp[prev:cur]
            c1 = int(s2[0]) - int('0')
            s2 = s2[1:]
            prev = cur + 1

            if s2 not in cost:
                cost[s2] = -1
            _v.append((c1, s2))

            if cur == len(tmp):
                break

        if s1 not in cost:
            cost[s1] = -1
        v.append((s1, _v))

    flag = True
    while flag:
        flag = False
        for i in range(len(v)):
            total = 0
            name = v[i][0]
            for j in range(len(v[i][1])):
                cnt = v[i][1][j][0]
                x = v[i][1][j][1]
                if cost[x] != -1:
                    total += cnt * cost[x]
                    if total > limit:
                        total = limit + 1
                else:
                    total = -1
                    break
            if total > 0:
                if cost[name] == -1 or cost[name] > total:
                    cost[name] = total
                    flag = True

    if "LOVE" not in cost:
        print(-1)
    else:
        print(cost["LOVE"])


if __name__ == "__main__":
    main()