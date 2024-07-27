WITH RECURSIVE Generation AS (
    -- 1세대 (PARENT_ID가 NULL인 개체들)
    SELECT 
        ID, 
        1 AS GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL

    UNION ALL

    -- 다음 세대들
    SELECT 
        e.ID, 
        g.GENERATION + 1
    FROM 
        ECOLI_DATA e
    JOIN 
        Generation g ON e.PARENT_ID = g.ID
    WHERE 
        g.GENERATION < 3
)
SELECT 
    ID
FROM 
    Generation
WHERE 
    GENERATION = 3
ORDER BY 
    ID;