select distinct car.car_id
from car_rental_company_car car
join car_rental_company_rental_history history
on car.car_id = history.car_id
where car.car_type = "세단" and date_format(start_date, "%Y%m") = "202210"
order by 1 desc