import sys

input = lambda: sys.stdin.readline().rstrip()

result = 0
for i in [3, 2, 1]:
    tmp = input()

    if tmp not in ['Fizz', 'Buzz', 'FizzBuzz']:
        result = int(tmp) + i

if result % 3 == 0 and result % 5 == 0:
    print('FizzBuzz')
elif result % 3 == 0:
    print('Fizz')
elif result % 5 == 0:
    print('Buzz')
else:
    print(result)