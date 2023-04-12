SELECT 
    board.title AS title,
    board.board_id,
    reply.reply_id,
    reply.writer_id,
    reply.contents,
    DATE_FORMAT(reply.created_date, '%Y-%m-%d') AS created_date
FROM
    used_goods_board board
        JOIN
    used_goods_reply reply ON board.board_id = reply.board_id
WHERE
    YEAR(board.created_date) = 2022
        AND MONTH(board.created_date) = 10
ORDER BY 6 , 1;