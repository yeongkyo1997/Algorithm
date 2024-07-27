WITH RECURSIVE Generation AS (
    -- 최초 세대 (PARENT_ID가 NULL인 개체들)
    SELECT 
        ID, 
        PARENT_ID, 
        1 AS GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL

    UNION ALL

    -- 재귀적으로 각 세대를 계산
    SELECT 
        e.ID, 
        e.PARENT_ID, 
        g.GENERATION + 1 AS GENERATION
    FROM 
        ECOLI_DATA e
    JOIN 
        Generation g ON e.PARENT_ID = g.ID
)
-- 각 세대별 자식이 없는 개체 수를 계산
SELECT 
    COUNT(*) AS COUNT, 
    GENERATION
FROM 
    Generation g
WHERE 
    NOT EXISTS (
        SELECT 1 
        FROM ECOLI_DATA e 
        WHERE e.PARENT_ID = g.ID
    )
GROUP BY 
    GENERATION
ORDER BY 
    GENERATION;