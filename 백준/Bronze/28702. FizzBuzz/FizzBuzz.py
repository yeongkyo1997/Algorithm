n = 0
for i in range(3, 0, -1):
    s = input()
    if s.isdigit():
        n = int(s) + i
        break

print('Fizz' * (n % 3 == 0) + 'Buzz' * (n % 5 == 0) or n)