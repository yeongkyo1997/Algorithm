import sys


def solve():
    x, y = map(int, sys.stdin.readline().split())

    is_time_valid = False
    if 0 <= x <= 23 and 0 <= y <= 59:
        is_time_valid = True

    days_in_month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    is_date_valid = False

    if 1 <= x <= 12:

        max_days = days_in_month[x]

        if 1 <= y <= max_days:
            is_date_valid = True

    time_result = "Yes" if is_time_valid else "No"
    date_result = "Yes" if is_date_valid else "No"
    print(f"{time_result} {date_result}")


T = int(sys.stdin.readline())


for _ in range(T):
    solve()
