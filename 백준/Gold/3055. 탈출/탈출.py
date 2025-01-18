from collections import deque
import sys

def main():
    R, C = map(int, sys.stdin.readline().split())
    grid = [list(sys.stdin.readline().strip()) for _ in range(R)]

    water_queue = deque()
    hedgehog_queue = deque()

    for i in range(R):
        for j in range(C):
            if grid[i][j] == '*':
                water_queue.append((i,j))
            elif grid[i][j] == 'S':
                hedgehog_queue.append((i,j))
            elif grid[i][j] == 'D':
                dest = (i,j)

    water_time = [[float('inf')] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if grid[i][j] == '*':
                water_time[i][j] = 0
            elif grid[i][j] == 'D' or grid[i][j] == 'S' or grid[i][j] == '.':
                water_time[i][j] = float('inf')
            elif grid[i][j] == 'X':
                water_time[i][j] = -1  # 불可达

    dx = [0,1,0,-1]
    dy = [1,0,-1,0]

    while water_queue:
        x, y = water_queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < R and 0 <= ny < C:
                if grid[nx][ny] == '.' and water_time[nx][ny] == float('inf'):
                    water_time[nx][ny] = water_time[x][y] + 1
                    water_queue.append((nx, ny))
                elif grid[nx][ny] == 'D':
                    continue  # 물이 D로 확장되지 않음

    hedgehog_time = [[float('inf')] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if grid[i][j] == 'S':
                hedgehog_time[i][j] = 0
            elif grid[i][j] == 'D' or grid[i][j] == '.' or grid[i][j] == '*':
                hedgehog_time[i][j] = float('inf')
            elif grid[i][j] == 'X':
                hedgehog_time[i][j] = -1

    visited = [[False]*C for _ in range(R)]
    visited_hedgehog = [[False]*C for _ in range(R)]

    while hedgehog_queue:
        x, y = hedgehog_queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < R and 0 <= ny < C:
                if grid[nx][ny] == '.' and not visited_hedgehog[nx][ny]:
                    if water_time[nx][ny] > hedgehog_time[x][y] + 1:
                        hedgehog_time[nx][ny] = hedgehog_time[x][y] + 1
                        visited_hedgehog[nx][ny] = True
                        hedgehog_queue.append((nx, ny))
                elif grid[nx][ny] == 'D':
                    if water_time[nx][ny] > hedgehog_time[x][y] + 1:
                        hedgehog_time[nx][ny] = hedgehog_time[x][y] + 1
                        print(hedgehog_time[nx][ny])
                        return
    print("KAKTUS")

if __name__ == "__main__":
    main()