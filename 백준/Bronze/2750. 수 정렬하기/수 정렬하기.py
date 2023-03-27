import sys

# 입력 받기
n = int(sys.stdin.readline())
arr = []
for _ in range(n):
    arr.append(int(sys.stdin.readline()))

# 오름차순 정렬
arr.sort()

# 정렬된 결과 출력
for x in arr:
    print(x)