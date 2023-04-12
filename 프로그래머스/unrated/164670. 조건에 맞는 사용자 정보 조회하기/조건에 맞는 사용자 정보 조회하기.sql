select user.user_id, user.nickname, concat_ws(" ", user.city, user.street_address1, user.street_address2) as 전체주소, case(length(user.tlno)) WHEN 11 THEN CONCAT(LEFT(user.tlno, 3), '-', MID(user.tlno, 4, 4), '-', RIGHT(user.tlno, 4))
        WHEN 10 THEN CONCAT(LEFT(user.tlno, 3), '-', MID(user.tlno, 4, 3), '-', RIGHT(user.tlno, 4))
	END as 전화번호
from used_goods_user user
where user.user_id in (
    select writer_id
    from used_goods_board
    group by 1
    having count(writer_id) >= 3
)
order by 1 desc