SELECT BO.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK BO
JOIN BOOK_SALES BS
ON BO.BOOK_ID = BS.BOOK_ID
WHERE DATE_FORMAT(BS.SALES_DATE, "%Y-%m") = "2022-01"
GROUP BY BO.CATEGORY
ORDER BY 1