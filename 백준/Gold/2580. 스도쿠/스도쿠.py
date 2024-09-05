import sys
import time



class DancingNode:
    def __init__(self, left=None, right=None, up=None, down=None, column=None, row=None):
        self.left = left or self
        self.right = right or self
        self.up = up or self
        self.down = down or self
        self.column = column
        self.row = row


class ColumnNode(DancingNode):
    def __init__(self, name):
        super().__init__()
        self.size = 0
        self.name = name


class DancingLinks:
    def __init__(self, sudoku):
        self.header = ColumnNode('header')
        self.columns = []
        self.rows = []
        self.solution = []
        self.setup_sudoku_constraints()
        self.add_sudoku_rows(sudoku)

    def setup_sudoku_constraints(self):
        for i in range(9 * 9 * 4):
            column = ColumnNode(str(i))
            self.columns.append(column)
            self.header.left.right = column
            column.left = self.header.left
            column.right = self.header
            self.header.left = column

    def add_sudoku_rows(self, sudoku):
        for r in range(9):
            for c in range(9):
                if sudoku[r][c] != 0:
                    self.add_row(r, c, sudoku[r][c])
                else:
                    for num in range(1, 10):
                        self.add_row(r, c, num)

    def add_row(self, r, c, num):
        row = []
        for j in range(4):
            node = DancingNode()
            if j == 0:
                col = r * 9 + c
            elif j == 1:
                col = 81 + r * 9 + num - 1
            elif j == 2:
                col = 162 + c * 9 + num - 1
            else:
                col = 243 + (r // 3 * 3 + c // 3) * 9 + num - 1

            column = self.columns[col]
            node.column = column
            node.row = (r, c, num)

            node.left = row[-1] if row else node
            node.right = row[0] if row else node
            if row:
                row[-1].right = node
                row[0].left = node

            node.up = column.up
            node.down = column
            column.up.down = node
            column.up = node
            column.size += 1

            row.append(node)
        self.rows.append(row)

    def cover(self, column):
        column.right.left = column.left
        column.left.right = column.right
        i = column.down
        while i != column:
            j = i.right
            while j != i:
                j.down.up = j.up
                j.up.down = j.down
                j.column.size -= 1
                j = j.right
            i = i.down

    def uncover(self, column):
        i = column.up
        while i != column:
            j = i.left
            while j != i:
                j.column.size += 1
                j.down.up = j
                j.up.down = j
                j = j.left
            i = i.up
        column.right.left = column
        column.left.right = column

    def search(self, k):
        if self.header.right == self.header:
            return True

        column = self.choose_column()
        self.cover(column)

        r = column.down
        while r != column:
            self.solution.append(r)
            j = r.right
            while j != r:
                self.cover(j.column)
                j = j.right
            if self.search(k + 1):
                return True
            r = self.solution.pop()
            j = r.left
            while j != r:
                self.uncover(j.column)
                j = j.left
            r = r.down

        self.uncover(column)
        return False

    def choose_column(self):
        min_size = float('inf')
        chosen_column = None
        column = self.header.right
        while column != self.header:
            if column.size < min_size:
                min_size = column.size
                chosen_column = column
            column = column.right
        return chosen_column

    def solve(self):
        return self.search(0)


def solve_sudoku(sudoku):
    dl = DancingLinks(sudoku)
    if dl.solve():
        solution = [[0] * 9 for _ in range(9)]
        for node in dl.solution:
            r, c, num = node.row
            solution[r][c] = num
        return solution
    return None


if __name__ == '__main__':
    sudoku = []
    for _ in range(9):
        row = list(map(int, input().split()))
        sudoku.append(row)

    # 스도쿠 풀기
    solution = solve_sudoku(sudoku)

    # 결과 출력
    if solution:
        for row in solution:
            print(' '.join(map(str, row)))