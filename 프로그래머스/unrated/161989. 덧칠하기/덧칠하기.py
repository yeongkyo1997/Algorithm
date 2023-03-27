def solution(n, m, section):
    board = [0] * (n + 1)
    
    for i in section:
        board[i] = 1
    
    result = 0
    
    for i in range(1, n + 1):
        if board[i] == 1:
            board[i:min(i + m, n)] = [0] * m
            result += 1
            
    return result
            
        