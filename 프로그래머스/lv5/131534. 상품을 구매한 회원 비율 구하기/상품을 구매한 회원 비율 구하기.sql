SELECT 
    YEAR(o.sales_date) AS year,
    MONTH(o.sales_date) AS month,
    COUNT(DISTINCT u.user_id) AS puchased_users,
    ROUND(COUNT(DISTINCT u.user_id) / (SELECT 
                    COUNT(user_id)
                FROM
                    user_info
                WHERE
                    YEAR(joined) = 2021),
            1) AS puchased_ratio
FROM
    online_sale o
        JOIN
    user_info u ON o.user_id = u.user_id
WHERE
    YEAR(u.joined) = 2021
GROUP BY year , month
ORDER BY year , month;
