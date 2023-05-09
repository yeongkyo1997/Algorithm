import datetime

n = int(input())
oldest_person = ("", datetime.date.today())
youngest_person = ("", datetime.date(1900, 1, 1))

for i in range(n):
    name, day, month, year = input().split()
    birthdate = datetime.date(int(year), int(month), int(day))
    if birthdate < oldest_person[1]:
        oldest_person = (name, birthdate)
    if birthdate > youngest_person[1]:
        youngest_person = (name, birthdate)

print(youngest_person[0])
print(oldest_person[0])