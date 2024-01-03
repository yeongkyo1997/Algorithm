import datetime

def solution(date1, date2):
    result = datetime.datetime(*date1) < datetime.datetime(*date2)
    return 1 if result else 0
