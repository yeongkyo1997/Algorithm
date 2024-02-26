def solution(data, ext, val_ext, sort_by):
    filtered_data = [item for item in data if item[{'code': 0, 'date': 1, 'maximum': 2, 'remain': 3}[ext]] < val_ext]

    sorted_data = sorted(filtered_data, key=lambda x: x[{'code': 0, 'date': 1, 'maximum': 2, 'remain': 3}[sort_by]])

    return sorted_data

