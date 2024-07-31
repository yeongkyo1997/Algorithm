S = ['CIRCLE', 'TRIANGLE', 'SQUARE']
C = ['YELLOW', 'RED', 'BLUE']
B = ['GRAY', 'WHITE', 'BLACK']
arr = [list(input().split()) for _ in range(9)]
N = int(input())
hap = []


# 합 경우의 수 구하기
def comb(path, start, depth):
    if depth == 3:
        tmp = [arr[p] for p in path]

        for i in range(3):
            visited = set()
            for t in tmp:
                visited.add(t[i])
            if len(visited) == 2:
                return
        hap.append(list(p + 1 for p in path))
        return
    for i in range(start, 9):
        path.append(i)
        comb(path, i + 1, depth + 1)
        path.pop()


comb([], 0, 0)
visited = set()
result = 0
flag = False

for _ in range(N):
    command = input().split()
    if command[0] == 'H':
        a, b, c = map(int, sorted(command[1:]))
        if [a, b, c] in hap and (a, b, c) not in visited:
            visited.add((a, b, c))
            result += 1
        else:
            result -= 1
    else:
        if len(visited) == len(hap) and not flag:
            result += 3
            flag = True
        else:
            result -= 1

print(result)