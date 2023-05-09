n = int(input())
condos = []
for _ in range(n):
    d, c = map(int, input().split())
    condos.append((d, c))

condos.sort()

candidates = [condos[0]]
for i in range(1, n):
    d, c = condos[i]
    if c < candidates[-1][1]:
        candidates.append((d, c))

print(len(candidates))