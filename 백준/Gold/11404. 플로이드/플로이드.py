import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

# 입력 받기
n = int(input())  # 도시의 개수
m = int(input())  # 버스의 개수

# 행렬 생성하기
INF = int(1e9)  # 무한대 값 정의하기
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신으로 가는 비용은 0으로 설정하기
for i in range(1, n + 1):
    matrix[i][i] = 0

# 버스 정보 입력 받기
for _ in range(m):
    a, b, c = map(int, input().split())  # 시작 도시, 도착 도시, 비용
    matrix[a][b] = min(matrix[a][b], c)  # 같은 노선이 여러 개일 수 있으므로 최소 비용으로 갱신하기

# 플로이드 워셜 알고리즘 수행하기
for k in range(1, n + 1):  # 거쳐가는 노드 k
    for i in range(1, n + 1):  # 출발 노드 i
        for j in range(1, n + 1):  # 도착 노드 j
            matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j])  # 최단 거리 갱신하기

# 출력하기
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if matrix[i][j] == INF:  # 연결되어 있지 않으면 0 출력하기
            print(0, end=' ')
        else:  # 연결되어 있으면 최단 거리 출력하기
            print(matrix[i][j], end=' ')
    print()