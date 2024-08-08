visited = [0] * 10001

for _ in range(int(input())):
    visited[int(input())] += 1

for i in range(1, 10001):
    for _ in range(visited[i]):
        print(i)
