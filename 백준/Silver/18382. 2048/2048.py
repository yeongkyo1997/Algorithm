def process_line(line):
    new_line = [num for num in line if num != 0]
    score_increase = 0
    merged_line = []
    skip = False
    for i in range(len(new_line)):
        if skip:
            skip = False
            continue
        if i + 1 < len(new_line) and new_line[i] == new_line[i + 1]:
            merged_value = new_line[i] * 2
            merged_line.append(merged_value)
            score_increase += merged_value
            skip = True
        else:
            merged_line.append(new_line[i])
    while len(merged_line) < 4:
        merged_line.append(0)
    return merged_line, score_increase


def move_board(grid, direction):
    score_increase = 0
    tmp = [row[:] for row in grid]

    for i in range(4):
        if direction in ['L', 'R']:
            line = tmp[i]
            if direction == 'R':
                line = line[::-1]
            processed_line, inc = process_line(line)
            score_increase += inc
            if direction == 'R':
                processed_line = processed_line[::-1]
            tmp[i] = processed_line
        elif direction in ['U', 'D']:
            line = [tmp[row][i] for row in range(4)]
            if direction == 'D':
                line = line[::-1]
            processed_line, inc = process_line(line)
            score_increase += inc
            if direction == 'D':
                processed_line = processed_line[::-1]
            for row in range(4):
                tmp[row][i] = processed_line[row]

    return tmp, score_increase


def main():
    import sys

    S = int(sys.stdin.readline())
    move_str = sys.stdin.readline().strip()
    data = list(map(int, sys.stdin.readline().strip().split()))
    board = [data[i * 4:(i + 1) * 4] for i in range(4)]

    moves = []
    for i in range(0, len(move_str), 4):
        move_part = move_str[i:i + 4]
        if len(move_part) < 4:
            continue
        d = move_part[0]
        val = int(move_part[1])
        row = int(move_part[2])
        col = int(move_part[3])
        moves.append((d, val, row, col))

    score = S
    for move in moves:
        d, val, row, col = move
        board, inc = move_board(board, d)
        score += inc
        if board[row][col] != 0:
            pass
        board[row][col] = val

    print(score)


if __name__ == "__main__":
    main()