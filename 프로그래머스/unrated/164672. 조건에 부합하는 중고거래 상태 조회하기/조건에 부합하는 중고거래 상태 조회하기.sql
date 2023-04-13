select board_id, writer_id, title, price,
case 
    when status = "DONE"
    then "거래완료"
    when status = "SALE"
    then "판매중"
    when status = "RESERVED"
    then "예약중"
end as status
from used_goods_board
where date_format(created_date,"%Y%m%d") = "20221005"
order by 1 desc