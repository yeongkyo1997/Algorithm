import sys


def input(): return sys.stdin.readline().rstrip()


def solution(N, K, table):
    people = [i for i in range(N) if table[i] == 'P']
    hamburgers = [i for i in range(N) if table[i] == 'H']

    cnt = 0
    for p in people:
        for h in hamburgers:
            if abs(p - h) <= K:
                cnt += 1
                hamburgers.remove(h)
                break

    return cnt


N, K = map(int, input().split())
table = input()

print(solution(N, K, table))