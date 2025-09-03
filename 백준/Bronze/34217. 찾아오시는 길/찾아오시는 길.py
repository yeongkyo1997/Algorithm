A, B = map(int, input().split())
C, D = map(int, input().split())

hanyang = A + C
yongdap = B + D

if hanyang < yongdap:
    print("Hanyang Univ.")
elif hanyang > yongdap:
    print("Yongdap")
else:
    print("Either")