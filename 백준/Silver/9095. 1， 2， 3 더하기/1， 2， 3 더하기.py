import sys
import collections, functools

input = lambda: sys.stdin.readline().rstrip()


@functools.lru_cache(maxsize=32)
def solve(total):
    if total > N:
        return 0
    if total == N:
        return 1

    ret = 0
    for i in range(1, 4):
        total += i
        ret += solve(total)
        total -= i

    return ret


T = int(input())

result = []
for _ in range(T):
    N = int(input())
    result.append(solve(0))
    solve.cache_clear()

print("\n".join(map(str, result)))
