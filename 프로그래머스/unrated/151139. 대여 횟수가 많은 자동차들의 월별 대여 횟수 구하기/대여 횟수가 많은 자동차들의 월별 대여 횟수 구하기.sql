SELECT month(start_date) month, car_id, count(*) records
from car_rental_company_rental_history
where start_date >= '2022-08-01' and start_date < '2022-11-01'
    and car_id in (SELECT car_id
            from car_rental_company_rental_history
            where start_date >= '2022-08-01' and start_date < '2022-11-01'
            group by car_id
            having count(car_id) >= 5)
group by month, car_id
having records > 0
order by month, car_id desc;