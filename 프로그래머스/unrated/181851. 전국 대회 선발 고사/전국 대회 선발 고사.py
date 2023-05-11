def solution(rank, attendance):
    available_students = [i for i, attend in enumerate(attendance) if attend]
    sorted_available_students = sorted(available_students, key=lambda x: rank[x])
    a, b, c = sorted_available_students[:3]
    return 10000 * a + 100 * b + c
