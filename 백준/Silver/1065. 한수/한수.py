import sys

# 입력 받기
n = int(sys.stdin.readline())

# 한수의 개수 초기화
count = 0

# 한수인지 판별하는 함수
def is_hansu(x):
    # 한 자리 수나 두 자리 수면 한수임
    if x < 100:
        return True
    # 세 자리 수면 각 자리의 차이가 같은지 확인
    else:
        x = str(x)
        d = int(x[0]) - int(x[1])
        if d == int(x[1]) - int(x[2]):
            return True
        else:
            return False

# 1부터 n까지 반복하며 한수인지 확인하고 개수 증가
for i in range(1,n+1):
    if is_hansu(i):
        count += 1

# 한수의 개수 출력
print(count)