import collections


def split(str_):
    for i in range(0, len(str_) - sp, sp):
        s.add('0x' + ''.join(str_[i:i + sp]))


for t in range(1, int(input()) + 1):
    N, K = map(int, input().rstrip().split())
    sp = N // 4
    str_ = collections.deque(input())
    s = set()
    for _ in range(sp * 4):
        split(''.join(str_))
        str_.rotate(1)

    s = sorted(map(lambda x: int(x, 16), s), reverse=True)
    print(f'#{t} {s[K - 1]}')
