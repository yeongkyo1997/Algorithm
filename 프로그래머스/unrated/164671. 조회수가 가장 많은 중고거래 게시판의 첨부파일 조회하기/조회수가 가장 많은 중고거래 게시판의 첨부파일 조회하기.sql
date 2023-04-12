select concat("/home/grep/src/", file.board_id, "/", file.file_id, file_name, file_ext) as file_path
from used_goods_file file
join used_goods_board board
on file.board_id = board.board_id
where board.views = (select max(views) from used_goods_board)
order by file.file_id desc