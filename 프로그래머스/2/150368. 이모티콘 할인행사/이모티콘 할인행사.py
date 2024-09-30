def solution(users, emoticons):
    # 이모티콘 * 할인율에 대한 부분집합 구하기
    def get_subset(path, depth):
        """
        :param path: (할인율, 할인 후 이모티콘의 가격)
        :param depth:
        :return:
        """
        if depth == M:
            # 유저의 현재 구매 금액
            users_sale_point = [0] * N

            # 유저가 구매할 금액 정산
            for i in range(N):
                percent, _ = users[i]
                for sale, price in path:
                    # 할인율이 크다면
                    if percent <= sale * 100:
                        users_sale_point[i] += round(price * (1 - sale))

            plus = 0
            total = 0
            # 이모티콘 플러스로 교체
            for i in range(N):
                _, maximum = users[i]
                if maximum <= users_sale_point[i]:
                    plus += 1
                    users_sale_point[i] = 0
                total += users_sale_point[i]

            candi.append((-plus, -total, (plus, total)))

            return
        for val in discount:
            path.append((val, emoticons[depth]))
            get_subset(path, depth + 1)
            path.pop()

    N = len(users)
    M = len(emoticons)
    discount = [0.1, 0.2, 0.3, 0.4]
    candi = []
    get_subset([], 0)
    candi.sort()
    return list(candi[0][-1])
