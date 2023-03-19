import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

# 입력 받기
x = input()
y = input()

# 문자열의 길이 구하기
m = len(x)
n = len(y)

# 행렬 생성하기
matrix = [[0] * (n + 1) for _ in range(m + 1)]

# 동적 계획법 수행하기
for i in range(1, m + 1):
    for j in range(1, n + 1):
        # 두 문자가 같으면 왼쪽 위 칸에 1을 더함
        if x[i - 1] == y[j - 1]:
            matrix[i][j] = matrix[i - 1][j - 1] + 1
        # 두 문자가 다르면 왼쪽 칸과 위쪽 칸 중 큰 값으로 설정함
        else:
            matrix[i][j] = max(matrix[i - 1][j], matrix[i][j - 1])

# 출력하기
print(matrix[m][n])