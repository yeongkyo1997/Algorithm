L, C = map(int, input().rstrip().split())

arr = list(map(str, input().rstrip().split()))
arr = sorted(arr)

mo = 'aeiou'


def dfs(path, start):
    if len(path) == L:
        mo_cnt = 0
        ja_cnt = 0
        for p in path:
            if p in mo:
                mo_cnt += 1
            else:
                ja_cnt += 1

        if mo_cnt >= 1 and ja_cnt >= 2:
            print(path)

        return

    for i in range(start, C):
        dfs(path + arr[i], i + 1)

dfs('', 0)