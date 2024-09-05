import sys

input = lambda: sys.stdin.readline().rstrip()

INF = int(1e9)



class Node:
    def __init__(self):
        self.row = 0
        self.size = 0
        self.column = None
        self.up = None
        self.down = None
        self.left = None
        self.right = None


def cover(c):
    c.right.left = c.left
    c.left.right = c.right
    it = c.down
    while it != c:
        jt = it.right
        while jt != it:
            jt.down.up = jt.up
            jt.up.down = jt.down
            jt.column.size -= 1
            jt = jt.right
        it = it.down


def uncover(c):
    it = c.up
    while it != c:
        jt = it.left
        while jt != it:
            jt.down.up = jt
            jt.up.down = jt
            jt.column.size += 1
            jt = jt.left
        it = it.up
    c.right.left = c
    c.left.right = c


def search(head, ret):
    if head.right == head:
        return True
    ptr = None
    low = INF
    it = head.right
    while it != head:
        if it.size < low:
            if it.size == 0:
                return False
            low = it.size
            ptr = it
        it = it.right
    cover(ptr)
    it = ptr.down
    while it != ptr:
        ret.append(it.row)
        jt = it.right
        while jt != it:
            cover(jt.column)
            jt = jt.right
        if search(head, ret):
            return True
        else:
            ret.pop()
            jt = it.left
            while jt != it:
                uncover(jt.column)
                jt = jt.left
        it = it.down
    uncover(ptr)
    return False


def sol(matrix):
    n = len(matrix[0])
    column = [Node() for _ in range(n)]
    head = Node()
    head.right = column[0]
    head.left = column[n - 1]
    for i in range(n):
        column[i].size = 0
        column[i].up = column[i]
        column[i].down = column[i]
        column[i].left = head if i == 0 else column[i - 1]
        column[i].right = head if i == n - 1 else column[i + 1]
    nodes = []
    for i in range(len(matrix)):
        last = None
        for j in range(n):
            if matrix[i][j]:
                now = Node()
                now.row = i
                now.column = column[j]
                now.up = column[j].up
                now.down = column[j]
                if last:
                    now.left = last
                    now.right = last.right
                    last.right.left = now
                    last.right = now
                else:
                    now.left = now
                    now.right = now
                column[j].up.down = now
                column[j].up = now
                column[j].size += 1
                last = now
                nodes.append(now)
    ret = []
    search(head, ret)
    return ret


def main():
    mat = []
    data = []
    board = [[0] * 16 for _ in range(16)]
    for i in range(16):
        row = input().strip()
        for j, c in enumerate(row):
            board[i][j] = 0 if c == '-' else ord(c) - ord('A') + 1

            def make_row(k):
                row = [0] * 1024
                row[i * 16 + j] = 1
                row[256 + i * 16 + k] = 1
                row[256 * 2 + j * 16 + k] = 1
                row[256 * 3 + (i // 4 * 4 + j // 4) * 16 + k] = 1
                mat.append(row)
                data.append((i, j, k))

            if board[i][j]:
                make_row(board[i][j] - 1)
            else:
                for k in range(16):
                    make_row(k)

    for i in sol(mat):
        x, y, k = data[i]
        board[x][y] = k

    for i in range(16):
        print(''.join(chr(board[i][j] + ord('A')) for j in range(16)))


if __name__ == "__main__":
    main()