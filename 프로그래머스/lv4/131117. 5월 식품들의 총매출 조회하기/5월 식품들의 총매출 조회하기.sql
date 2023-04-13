select pro.product_id, pro.product_name, sum(pro.price * ord.amount)
from food_product pro
join  (
    select product_id, amount
    from food_order
    where "2022-05" = date_format(produce_date, "%Y-%m")
) ord
on pro.product_id = ord.product_id
group by 1
order by 3 desc, 1