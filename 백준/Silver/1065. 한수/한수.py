def is_hansu(number):
    if number < 100:
        return True

    digits = [int(d) for d in str(number)]
    diff = digits[1] - digits[0]

    for i in range(2, len(digits)):
        if digits[i] - digits[i - 1] != diff:
            return False

    return True

def count_hansu(n):
    count = 0
    for i in range(1, n + 1):
        if is_hansu(i):
            count += 1
    return count

N = int(input())
print(count_hansu(N))