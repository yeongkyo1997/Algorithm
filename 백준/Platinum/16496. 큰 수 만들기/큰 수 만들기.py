n = int(input())
numbers = list(map(str, input().split()))


def compare(a, b):
    if a + b > b + a:
        return True
    else:
        return False


for i in range(1, n):
    key = numbers[i]
    j = i - 1
    while j >= 0 and compare(key, numbers[j]):
        numbers[j + 1] = numbers[j]
        j -= 1
    numbers[j + 1] = key

answer = ''.join(numbers)
if answer[0] == '0':
    print('0')
else:
    print(answer)