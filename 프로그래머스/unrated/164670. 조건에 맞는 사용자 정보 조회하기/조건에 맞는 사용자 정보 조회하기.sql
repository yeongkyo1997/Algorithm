SELECT 
    user.user_id,
    user.nickname,
    CONCAT_WS(' ',
            user.city,
            user.street_address1,
            user.street_address2) AS 전체주소,
    CONCAT(LEFT(user.tlno, 3),
            '-',
            MID(user.tlno, 4, 4),
            '-',
            RIGHT(user.tlno, 4))
FROM
    used_goods_user user
WHERE
    user.user_id IN (SELECT 
            writer_id
        FROM
            used_goods_board
        GROUP BY 1
        HAVING COUNT(writer_id) >= 3)
ORDER BY 1 DESC