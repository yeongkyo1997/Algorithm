# import sys
# k, n = map(int, sys.stdin.readline().split())
# graph = [[float('inf')] * (k+1) for _ in range(k+1)]
#
# # i-1에서 i 사이에는 최대 1개가 올 수 있음
# # 자기자신은 0으로 초기화
# graph[0][0] = 0
# for i in range(1, k+1):
#     graph[i][i-1] = 0
#     graph[i][i] = 0
#     graph[i-1][i] = 1
#
# for _ in range(n):
#     x, y, r = map(int, sys.stdin.readline().split())
#     if graph[x-1][y] > r:
#         graph[x-1][y] = r
#     graph[y][x-1] = -r
# # 플로이드 워샬 알고리즘을 통해 올 수 있는 최소 개수를 구함
# for i in range(k+1):
#     for j in range(k+1):
#         for h in range(k+1):
#             if graph[j][h] > graph[j][i] + graph[i][h]:
#                 graph[j][h] = graph[j][i] + graph[i][h]
# # 만약 0보다 작은 것이 있다면 존재할 수 없는 위치가 있으므로 NONE을 출력
# for i in range(k):
#     if graph[i][i] < 0:
#         print('NONE')
#         exit()
# # i와 i-1의 차이가 1이라면 #을 출력
# print(''.join(['#' if graph[0][i]-graph[0][i-1] ==1 else '-' for i in range(1,k+1)]))