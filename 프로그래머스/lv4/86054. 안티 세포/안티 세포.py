MAX = 50
MOD = 1e9+7


def find(n, a):
    ret = 1
    dp = [[0] * MAX for _ in range(n)]
    SUM = [0] * n
    dp[0][0] = 1

    for i in range(1, n):
        flag = False
        SUM[i] = SUM[i-1] + a[i-1]
        dp[i][0] = ret
        e = i
        t = a[i]

        for j in range(1, MAX):
            if not e > 0:
                break

            cur = a[e-1]

            for k in range(MAX):
                if cur > t or dp[e-1][k] == 0:
                    flag = True
                    break
                if cur == t:
                    dp[i][j] = dp[e - 1][k]
                    ret += dp[i][j]
                    ret %= MOD
                    break

                cur *= 2

            if flag:
                break
            e = bs(0, e, t, SUM)
            t *= 2
        if flag:
            continue

    return ret


def bs(s, e, target, SUM):
    flag = SUM[e]
    while s <= e:
        mid = (s + e) // 2
        if flag - SUM[mid] == target:
            return mid
        elif flag - SUM[mid] > target:
            s = mid + 1
        else:
            e = mid - 1

    return -1


def solution(a, s):
    n = len(s)
    pre = 0
    ret = [0] * n
    for i in range(n):
        tmp = a[pre:pre + s[i]]
        ret[i] = find(s[i], tmp)
        pre += s[i]

    return ret
