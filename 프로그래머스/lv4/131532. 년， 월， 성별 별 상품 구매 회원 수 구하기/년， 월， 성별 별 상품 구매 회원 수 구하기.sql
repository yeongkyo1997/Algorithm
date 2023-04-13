SELECT 
    YEAR(o.sales_date) AS year,
    MONTH(o.sales_date) AS month,
    u.gender,
    COUNT(DISTINCT u.user_id) AS users
FROM
    user_info u
        JOIN
    online_sale o ON u.user_id = o.user_id
WHERE
    u.gender IS NOT NULL
GROUP BY year , month , gender
ORDER BY year , month , gender