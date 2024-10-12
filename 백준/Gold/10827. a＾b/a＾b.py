import decimal

decimal.getcontext().prec = 2000
if __name__ == '__main__':
    a, b = input().split()
    a = decimal.Decimal(a)
    result = format(a ** int(b), 'f')
    print(result)