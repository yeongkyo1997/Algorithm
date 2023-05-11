def solution(board, k):
    n = len(board) 
    m = len(board[0])
    answer = 0
    for i in range(n):
        for j in range(min(m, k-i+1)):
            answer += board[i][j]
    return answer
