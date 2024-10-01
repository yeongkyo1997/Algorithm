import sys
from functools import cmp_to_key

input = lambda: sys.stdin.readline().rstrip()


def largest_number():
    # 입력 받기
    N = int(input())

    # 모든 숫자를 문자열로 변환
    numbers = input().split()

    # 비교 함수 정의
    def compare(a, b):
        if a + b > b + a:
            return -1  # a가 b보다 먼저 오도록
        elif a + b < b + a:
            return 1  # b가 a보다 먼저 오도록
        else:
            return 0

    # 사용자 정의 정렬
    numbers.sort(key=cmp_to_key(compare))

    # 모든 숫자가 '0'인 경우 '0' 하나만 출력
    if numbers[0] == '0':
        print('0')
    else:
        print(''.join(numbers))


# 함수 호출
if __name__ == "__main__":
    largest_number()