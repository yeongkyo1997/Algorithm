from collections import deque

def solution(maps):
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    n = len(maps)
    m = len(maps[0])
    
    q = deque()
    q.append((0, 0, 1))
    
    while q:
        x, y, depth = q.popleft()
        
        if x == n - 1 and y == m - 1:
            return depth
        
        for i in range(4):
            nx, ny, ndepth = x + dx[i], y + dy[i], depth + 1
            
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1:
                maps[nx][ny] = 0
                q.append((nx, ny, ndepth))
    
    return -1