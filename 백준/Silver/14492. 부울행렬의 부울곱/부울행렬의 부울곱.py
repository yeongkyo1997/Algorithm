import sys


n = int(sys.stdin.readline())


matrix_a = []
for _ in range(n):

    matrix_a.append(list(map(int, sys.stdin.readline().split())))


matrix_b = []
for _ in range(n):

    matrix_b.append(list(map(int, sys.stdin.readline().split())))


count_ones = 0


for i in range(n):

    for j in range(n):

        c_ij = 0
        for k in range(n):

            if matrix_a[i][k] == 1 and matrix_b[k][j] == 1:

                c_ij = 1

                break

        if c_ij == 1:
            count_ones += 1


print(count_ones)
