def get_input():
    initial_input = input()
    s = input()
    num_executions = int(input())
    min_position, max_position = map(int, input().split())
    return initial_input, s, num_executions, min_position, max_position


def execute_endless_program(initial_input, s, num_executions):
    for _ in range(num_executions):
        updated_s = s.replace('$', initial_input)
        initial_input = updated_s
    return initial_input


def print_result(result, min_position, max_position):
    final_result = result[min_position - 1: max_position]
    if not final_result:
        print('-')
    else:
        if len(final_result) < max_position - min_position + 1:
            final_result = final_result.ljust(max_position - min_position + 1, '-')
        print(final_result)


def main():
    initial_input, s, num_executions, min_position, max_position = get_input()
    result = execute_endless_program(initial_input, s, num_executions)
    print_result(result, min_position, max_position)


if __name__ == "__main__":
    main()
