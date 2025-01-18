SELECT 
    fp.CATEGORY, 
    fp.PRICE AS MAX_PRICE, 
    fp.PRODUCT_NAME
FROM 
    FOOD_PRODUCT fp
JOIN (
    SELECT 
        CATEGORY, 
        MAX(PRICE) AS MAX_PRICE
    FROM 
        FOOD_PRODUCT
    WHERE 
        CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY 
        CATEGORY
) AS sub
    ON fp.CATEGORY = sub.CATEGORY 
    AND fp.PRICE = sub.MAX_PRICE
WHERE 
    fp.CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY 
    fp.PRICE DESC;