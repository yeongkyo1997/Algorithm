def fibonacci(n):
    if n == 0:
        return '0'
    elif n == 1:
        return '1'

    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return str(b)


# 입력 받기
n = int(input())
# 결과 출력
print(fibonacci(n))