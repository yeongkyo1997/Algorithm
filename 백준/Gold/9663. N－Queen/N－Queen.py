def solve_n_queen(n):
    def dfs(row, col, diag, anti_diag):
        nonlocal count
        # 모든 행에 퀸을 배치한 경우
        if row == n:
            count += 1
            return
        
        # 해당 행에서 퀸을 놓을 수 있는 위치들 (비트마스크)
        avail = ((1 << n) - 1) & ~(col | diag | anti_diag)
        while avail:
            # avail에서 가장 오른쪽에 있는 1 추출
            pos = avail & -avail
            avail -= pos  # 해당 비트를 제거
            
            # 다음 행에서의 재귀 호출:
            # col에 pos를 추가, 대각선 이동에 맞게 shift
            dfs(row + 1, col | pos, (diag | pos) << 1, (anti_diag | pos) >> 1)
    
    count = 0
    dfs(0, 0, 0, 0)
    return count

if __name__ == "__main__":
    import sys
    n = int(sys.stdin.readline().strip())
    print(solve_n_queen(n))