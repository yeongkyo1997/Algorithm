SELECT 
    ID,
    CASE 
        WHEN percent <= 25 THEN 'CRITICAL'
        WHEN percent <= 50 THEN 'HIGH'
        WHEN percent <= 75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (
    SELECT 
        ID,
        PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) * 100 AS percent
    FROM ECOLI_DATA
) ranked_data
ORDER BY ID;