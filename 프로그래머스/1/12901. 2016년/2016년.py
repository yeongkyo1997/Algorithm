from datetime import date

def solution(a, b):
    day = date(2016, a, b).weekday()

    return ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"][day]

