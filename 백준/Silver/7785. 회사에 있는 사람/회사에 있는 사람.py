from collections import defaultdict

n = int(input())
arr = [input().split() for _ in range(n)]
lib = defaultdict(int)
for a, b in arr:
    if b == 'enter':
        lib[a] += 1
    else:
        lib[a] -= 1

print(*[i[0] for i in sorted(lib.items(),
      key=lambda x: x[0], reverse=True) if i[1]], sep='\n')