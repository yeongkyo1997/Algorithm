import sys
from itertools import combinations

input = lambda: sys.stdin.readline().rstrip()


def make_bit(word):
    ret = 0
    for w in word:
        ret |= (1 << ord(w) - a)
    return ret


if __name__ == '__main__':
    N, K = map(int, input().split())
    flag = 0
    a = ord('a')
    for alpha in 'antic':
        flag |= 1 << (ord(alpha) - a)
    words = [set(input()) - set('antic') for _ in range(N)]
    alpha = [1 << i for i in range(26) if not (flag & (1 << i))]
    bits = list(map(make_bit, words))
    result = 0
    if K - 5 >= 0:
        for comb in combinations(alpha, K - 5):
            total_comb = sum(comb) | flag
            cnt = 0

            for bit in bits:
                if bit & total_comb == bit:
                    cnt += 1

            result = max(result, cnt)

    print(result)