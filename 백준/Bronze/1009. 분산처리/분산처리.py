def find_last_computer(a, b):
    a %= 10
    if a == 0:
        return 10

    result = a ** (b % 4 + 4) % 10
    return result

T = int(input())

for _ in range(T):
    a, b = map(int, input().split())
    print(find_last_computer(a, b))