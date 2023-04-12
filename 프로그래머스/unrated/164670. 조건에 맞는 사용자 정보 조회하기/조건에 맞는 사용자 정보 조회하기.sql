select user.user_id, user.nickname, concat_ws(" ", user.city, user.street_address1, user.street_address2) as 전체주소, CONCAT(LEFT(user.tlno, 3), '-', MID(user.tlno, 4, 4), '-', RIGHT(user.tlno, 4))
from used_goods_user user
where user.user_id in (
    select writer_id
    from used_goods_board
    group by 1
    having count(writer_id) >= 3
)
order by 1 desc