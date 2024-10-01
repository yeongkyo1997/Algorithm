import sys

input = lambda: sys.stdin.readline().rstrip()
# 함수 호출
if __name__ == "__main__":
    N = int(input())
    words = [input() for _ in range(N)]

    lib = {}

    for word in words:
        length = len(word)
        for i, alpha in enumerate(word):
            weight = 10 ** (length - i - 1)
            if alpha in lib:
                lib[alpha] += weight
            else:
                lib[alpha] = weight

    # 문자들을 가중치에 따라 내림차순으로 정렬
    sorted_letters = sorted(lib.items(), key=lambda x: x[1], reverse=True)

    # 숫자 할당 (가중치가 높은 문자부터 9부터 차례대로 할당)
    digit = 9
    char_to_digit = {}
    for alpha, weight in sorted_letters:
        char_to_digit[alpha] = digit
        digit -= 1

    # 각 단어를 숫자로 변환하여 총합 계산
    total_sum = 0
    for word in words:
        num = 0
        for alpha in word:
            num = num * 10 + char_to_digit[alpha]
        total_sum += num

    print(total_sum)