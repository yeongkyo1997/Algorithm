import sys

input = lambda: sys.stdin.readline().rstrip()

string = input()

dic = {'NLCS': 'North London Collegiate School',
       'BHA': 'Branksome Hall Asia',
       'KIS': 'Korea International School',
       'SJA': 'St. Johnsbury Academy'}

print(dic[string])
