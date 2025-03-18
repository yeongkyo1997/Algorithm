import sys

input = lambda: sys.stdin.readline().rstrip()


def dfs(path, start, depth):
    if depth == L:
        mo_cnt = 0
        ja_cnt = 0
        for p in path:
            if p in mo:
                mo_cnt += 1
            else:
                ja_cnt += 1

        if mo_cnt >= 1 and ja_cnt >= 2:
            print("".join(path))
        return

    for i in range(start, C):
        path.append(alpha[i])
        dfs(path, i + 1, depth + 1)
        path.pop()


mo = ["a", "e", "i", "o", "u"]
mo = set(mo)


L, C = map(int, input().split())
alpha = list(input().split())
alpha.sort()

dfs([], 0, 0)
