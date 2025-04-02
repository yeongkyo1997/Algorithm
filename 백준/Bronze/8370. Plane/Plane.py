import sys


n1, k1, n2, k2 = map(int, sys.stdin.readline().split())


business_seats = n1 * k1


economic_seats = n2 * k2


total_seats = business_seats + economic_seats


print(total_seats)
