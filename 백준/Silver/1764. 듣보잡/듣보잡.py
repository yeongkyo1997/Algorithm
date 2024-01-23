N, M = map(int, input().split())

a1 = set(input() for _ in range(N))
a2 = set(input() for _ in range(M))
result = a1 & a2
print(len(result))
print(*sorted(result), sep='\n')