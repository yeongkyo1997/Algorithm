select p.product_id, p.product_name, sum(p.price * o.amount) as total_sales
from food_product as p join food_order as o
on p.product_id = o.product_id
where o.produce_date between "2022-05-01" and "2022-05-31"
group by p.product_id
order by total_sales desc