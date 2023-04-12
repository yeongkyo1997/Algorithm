select user.user_id, user.nickname, sum(board.price) as total_sales
from used_goods_user user
join used_goods_board board
on user.user_id = board.writer_id
where status = "done"
group by board.writer_id
having total_sales >= 700000
order by total_sales