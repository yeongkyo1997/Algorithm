SELECT 
    car_id,
    ROUND(AVG(DATEDIFF(end_date, start_date) + 1),
            1) AS 'average_duration'
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY car_id
HAVING average_duration >= 7
ORDER BY 2 DESC , 1 DESC