WITH RECURSIVE CTE AS (
    -- 1) 최초 세대: 부모가 없는(= NULL) 개체
    SELECT
        ID,
        1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    -- 2) 재귀 단계: 바로 이전 CTE 결과를 보고 자식 개체를 찾아 GEN을 1씩 증가
    SELECT
        E.ID,
        C.GEN + 1
    FROM ECOLI_DATA E
    INNER JOIN CTE C ON E.PARENT_ID = C.ID
)

-- 3) 자식이 없는 개체만 골라 세대별로 집계
SELECT
    COUNT(*) AS COUNT,
    GEN AS GENERATION
FROM CTE
WHERE ID NOT IN (
    SELECT DISTINCT PARENT_ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NOT NULL
)
GROUP BY GEN
ORDER BY GEN;
