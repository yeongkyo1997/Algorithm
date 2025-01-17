-- 코드를 입력하세요

WITH JoinedUsers AS (
    SELECT USER_ID
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
),
TotalUsers AS (
    SELECT COUNT(*) AS total
    FROM JoinedUsers
),
PurchasedUsers AS (
    SELECT 
        YEAR(SALES_DATE) AS YEAR, 
        MONTH(SALES_DATE) AS MONTH, 
        COUNT(DISTINCT USER_ID) AS PURCHASED_USERS
    FROM ONLINE_SALE
    WHERE USER_ID IN (SELECT USER_ID FROM JoinedUsers)
    GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE)
)
SELECT 
    p.YEAR,
    p.MONTH,
    p.PURCHASED_USERS,
    ROUND(p.PURCHASED_USERS / t.total, 1) AS PUCHASED_RATIO
FROM PurchasedUsers p
JOIN TotalUsers t
ORDER BY 
    p.YEAR ASC,
    p.MONTH ASC;