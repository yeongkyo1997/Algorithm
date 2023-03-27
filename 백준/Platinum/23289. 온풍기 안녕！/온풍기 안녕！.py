from collections import deque
from sys import stdin

input = stdin.readline
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

r, c, k = map(int, input().split())
temperature = [[[0, 0, 0] for _ in range(c)] for _ in range(r)]
visited = [[0] * c for _ in range(r)]
v_num = 0

targets = []
heaters = []
for x in range(r):
    tmp = list(map(int, input().split()))
    for y in range(c):
        if tmp[y] == 5:
            targets.append((x, y))
        elif tmp[y] > 0:
            if tmp[y] == 1:
                type = 1
            elif tmp[y] == 2:
                type = 3
            elif tmp[y] == 3:
                type = 0
            else:
                type = 2
            heaters.append((x, y, type))

w = int(input())
wall = [[[False] * 4 for _ in range(c)] for _ in range(r)]
for _ in range(w):
    x, y, t = map(int, input().split())
    x -= 1
    y -= 1
    if t == 0:
        wall[x][y][0] = wall[x - 1][y][2] = True
    else:
        wall[x][y][1] = wall[x][y + 1][3] = True

def solve():
    result = 0
    while True:
        heat()
        setting()
        result += 1
        if check_targets():
            print(result)
            return
        if result == 100:
            print(101)
            return

def check_targets():
    for x, y in targets:
        if temperature[x][y][0] < k:
            return False
    return True

def setting():
    global temperature
    
    for x in range(r):
        for y in range(c):
            if temperature[x][y][0] == 0:
                continue
            for d in range(4):
                nx = x + dx[d]
                ny = y + dy[d]
                if point_val(nx, ny, (d + 2) % 4, False) and temperature[x][y][0] > temperature[nx][ny][0]:
                    temperature[nx][ny][1] += (temperature[x][y][0] - temperature[nx][ny][0]) // 4
                    temperature[x][y][2] += (temperature[x][y][0] - temperature[nx][ny][0]) // 4
    
    for x in range(r):
        for y in range(c):
            temperature[x][y][0] += temperature[x][y][1] - temperature[x][y][2]
            temperature[x][y][1] = temperature[x][y][2] = 0
    
    for x in range(r):
        for y in range(c):
            if x == 0 or y == 0 or x == r - 1 or y == c - 1:
                if temperature[x][y][0] > 0:
                    temperature[x][y][0] -= 1

def heat():
    global temperature, visited, v_num
    
    for sx, sy, typ in heaters:
        v_num += 1
        sx += dx[typ]
        sy += dy[typ]
        
        q = deque([(sx, sy)])
        visited[sx][sy] = v_num
        
        temperature[sx][sy][0] += 5
        
        for val in range(4, 0, -1):
            if not q:
                break
            length = len(q)
            for idx in range(length):
                x, y = q.pop()
                nx = x + dx[typ] + dx[(typ - 1) % 4]
                ny = y + dy[typ] + dy[(typ - 1) % 4]
                if point_val(nx, ny, (typ + 2) % 4) and not wall[x][y][(typ - 1) % 4]:
                    temperature[nx][ny][0] += val
                    visited[nx][ny] = v_num
                    q.appendleft((nx, ny))
                
                nx = x + dx[typ]
                ny = y + dy[typ]
                if point_val(nx, ny, (typ + 2) % 4):
                    temperature[nx][ny][0] += val
                    visited[nx][ny] = v_num
                    q.appendleft((nx, ny))
                
                nx = x + dx[typ] + dx[(typ + 1) % 4]
                ny = y + dy[typ] + dy[(typ + 1) % 4]
                if point_val(nx, ny, (typ + 2) % 4) and not wall[x][y][(typ + 1) % 4]:
                    temperature[nx][ny][0] += val
                    visited[nx][ny] = v_num
                    q.appendleft((nx, ny))

def point_val(x, y, type, flag=True):
    if x < 0 or y < 0 or x >= r or y >= c:
        return False
    elif wall[x][y][type]:
        return False
    elif flag and visited[x][y] == v_num:
        return False
    return True

solve()