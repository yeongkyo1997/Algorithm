import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

# BOJ 1043 - 거짓말
def main():
    N, M = map(int, input().split())
    know = list(map(int, input().split()))
    if know[0] == 0:
        print(M)
        return
    know = know[1:]
    party = [list(map(int, input().split())) for _ in range(M)]
    graph = [[0] * (N + 1) for _ in range(N + 1)]
    for i in range(M):
        for j in range(1, party[i][0] + 1):
            for k in range(j + 1, party[i][0] + 1):
                graph[party[i][j]][party[i][k]] = 1
                graph[party[i][k]][party[i][j]] = 1
    for i in range(N + 1):
        graph[i][i] = 1
    for k in range(N + 1):
        for i in range(N + 1):
            for j in range(N + 1):
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = 1
    result = 0
    for i in range(M):
        flag = 0
        for j in range(1, party[i][0] + 1):
            if flag:
                break
            for k in know:
                if graph[party[i][j]][k]:
                    flag = 1
                    break
        if not flag:
            result += 1
    print(result)

if __name__ == '__main__':
    main()