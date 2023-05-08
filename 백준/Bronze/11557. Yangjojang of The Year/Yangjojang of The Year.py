t = int(input()) 

for _ in range(t):
    n = int(input()) 
    schools = []
    for i in range(n):
        name, amount = input().split() 
        schools.append((name, int(amount)))
    max_school = max(schools, key=lambda x: x[1])
    print(max_school[0])