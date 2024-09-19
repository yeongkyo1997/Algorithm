import collections
import sys

def find_position(num):
    # 좋아하는 학생 수 구하기
    def get_favorite_student(x, y):
        ret = 0
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] in students[num]:
                ret += 1

        return ret

    # 빈자리 수 구하기
    def get_empty(x, y):
        ret = 0
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 0:
                ret += 1

        return ret

    candi = []
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                # 좋아하는 학생 수 구하기
                like = get_favorite_student(i, j)
                empty = get_empty(i, j)
                candi.append((-like, -empty, i, j, (i, j, like)))

    candi.sort()

    row, col, like = candi[0][-1]

    board[row][col] = num


if __name__ == '__main__':
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    N = int(input())
    board = [[0] * N for _ in range(N)]

    students = collections.defaultdict(set)

    result = 0
    for _ in range(N ** 2):
        data = list(map(int, input().split()))
        num = data[0]
        students[num] = set(data[1:])
        find_position(num)

    for x in range(N):
        for y in range(N):
            like = 0
            for dx, dy in dir:
                nx, ny = x + dx, y + dy

                if 0 <= nx < N and 0 <= ny < N and board[nx][ny] in students[board[x][y]]:
                    like += 1
            if like > 0:
                result += 10 ** (like - 1)

    print(result)