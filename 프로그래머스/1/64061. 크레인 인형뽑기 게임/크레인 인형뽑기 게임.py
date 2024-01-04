def solution(board, moves):
    lib = {i + 1: [] for i in range(len(board))}
    result = 0
    stack = []

    for i in range(len(board) - 1, -1, -1):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                continue
            lib[j + 1].append(board[i][j])

    for i in moves:
        if lib[i]:
            tmp = lib[i].pop()
            if not stack:
                stack.append(tmp)
            else:
                if stack[-1] == tmp:
                    stack.pop()
                    result += 1
                else:
                    stack.append(tmp)

    return result * 2

