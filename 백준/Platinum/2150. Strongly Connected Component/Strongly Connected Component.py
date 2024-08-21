import sys
from collections import defaultdict

sys.setrecursionlimit(10 ** 5)
input = lambda: sys.stdin.readline().rstrip()

MAX = 10001


def dfs(cur):
    global idx
    stack.append(cur)
    ret = idx
    id[cur] = idx
    idx += 1

    for ele in lib[cur]:
        if id[ele] == 0:
            ret = min(ret, dfs(ele))
        elif not already[ele]:
            ret = min(ret, id[ele])

    if ret == id[cur]:
        scc = set()
        while True:
            top = stack.pop()
            scc.add(top)
            id[top] = ret
            already[top] = True
            if top == cur:
                break
        result.append(scc)

    return ret


V, E = map(int, input().split())
id = [0] * (V + 1)
already = [False] * (V + 1)
lib = defaultdict(list)
stack = []
result = []
idx = 1

for _ in range(E):
    a, b = map(int, input().split())
    lib[a].append(b)

for i in range(1, V + 1):
    if not id[i]:
        dfs(i)

result = sorted(map(lambda x: sorted(x), result))

print(len(result))
for scc in result:
    print(*scc, -1)