import sys
from functools import lru_cache

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N, K = map(int, input().split())


    @lru_cache(maxsize=None)
    def dp(pos, balance, is_invalid):
        if pos == N:
            if is_invalid or balance != 0:
                return 1
            else:
                return 0
        ret = 0
        ret += dp(pos + 1, balance + 1, is_invalid)
        if balance > 0:
            ret += dp(pos + 1, balance - 1, is_invalid)
        else:
            ret += dp(pos + 1, balance - 1, True)
        return ret


    total = dp(0, 0, False)
    if K >= total:
        print(-1)
        exit(0)

    result = []
    pos = 0
    balance = 0
    is_invalid = False

    while pos < N:
        cnt = dp(pos + 1, balance + 1, is_invalid)
        if K < cnt:
            result.append('(')
            pos += 1
            balance += 1
        else:
            K -= cnt
            if balance > 0:
                cnt_with_close = dp(pos + 1, balance - 1, is_invalid)
                if K < cnt_with_close:
                    result.append(')')
                    pos += 1
                    balance -= 1
                else:
                    K -= cnt_with_close
            else:
                cnt_with_close = dp(pos + 1, balance - 1, True)
                if K < cnt_with_close:
                    result.append(')')
                    pos += 1
                    balance -= 1
                    is_invalid = True
                else:
                    K -= cnt_with_close

    print(''.join(result))