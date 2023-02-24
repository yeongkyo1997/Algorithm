import collections
import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M = map(int, input().split())
    deq = collections.deque()
    board = [list(map(int, list(input()))) for i in range(N)]
    
    deq.appendleft((0, 0, 1))
    board[0][0] = 0
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    while deq:
        cur = deq.pop()
        if cur[0] == N - 1 and cur[1] == M - 1:
            print(cur[2])
            break
        
        for i in range(4):
            nx = cur[0] + dx[i]
            ny = cur[1] + dy[i]
            ndepth = cur[2] + 1
            
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 1:
                board[nx][ny] = 0
                deq.appendleft((nx, ny, ndepth))

if __name__ == '__main__':
    main()