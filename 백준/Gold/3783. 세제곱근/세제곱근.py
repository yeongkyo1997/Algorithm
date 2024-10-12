import decimal
import sys

decimal.getcontext().prec = 1000

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    for _ in range(int(input())):
        x = decimal.Decimal(input())
        num = round(decimal.Decimal(x ** (decimal.Decimal('1') / (decimal.Decimal('3')))), 500)
        print(num.quantize(decimal.Decimal('.0000000000'), rounding=decimal.ROUND_DOWN))