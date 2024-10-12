import decimal

decimal.getcontext().prec = 1005

if __name__ == '__main__':
    A, B = input().split()
    print(decimal.Decimal(A) / decimal.Decimal(B))