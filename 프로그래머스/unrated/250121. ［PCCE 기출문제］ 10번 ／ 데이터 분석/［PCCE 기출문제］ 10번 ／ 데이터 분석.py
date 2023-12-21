def solution(data, ext, val_ext, sort_by):
    mapping = {"code": 0, "date": 1, "maximum": 2, "remain": 3}
    ext_index = mapping[ext]
    sort_by_index = mapping[sort_by]

    filtered_data = [item for item in data if item[ext_index] < val_ext]

    sorted_data = sorted(filtered_data, key=lambda x: x[sort_by_index])
    
    return sorted_data

