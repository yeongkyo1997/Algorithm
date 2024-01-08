def solution(keyinput, board):
    x, y = 0, 0
    arrow = {
        'up' : [0, 1],
        'down' : [0, -1],
        'left' : [-1, 0],
        'right' : [1, 0]
    }
    
    limit_x, limit_y = (board[0] - 1) // 2, (board[1] - 1) // 2
    
    for i in keyinput:
        dx, dy = arrow[i]
        x = max(min(x + dx, limit_x), -limit_x)
        y = max(min(y + dy, limit_y), -limit_y)
    
    return [x, y]