WITH FrontEndCode AS (
    SELECT SUM(CODE) AS TotalCode
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
),
PythonCode AS (
    SELECT CODE
    FROM SKILLCODES
    WHERE NAME = 'Python'
),
CSharpCode AS (
    SELECT CODE
    FROM SKILLCODES
    WHERE NAME = 'C#'
)
SELECT 
    CASE 
        WHEN (d.SKILL_CODE & f.TotalCode) > 0 AND (d.SKILL_CODE & p.CODE) > 0 THEN 'A'
        WHEN (d.SKILL_CODE & c.CODE) > 0 THEN 'B'
        WHEN (d.SKILL_CODE & f.TotalCode) > 0 THEN 'C'
    END AS GRADE,
    d.ID,
    d.EMAIL
FROM 
    DEVELOPERS d
CROSS JOIN FrontEndCode f
CROSS JOIN PythonCode p
CROSS JOIN CSharpCode c
WHERE 
    (d.SKILL_CODE & f.TotalCode) > 0 
    OR (d.SKILL_CODE & p.CODE) > 0
    OR (d.SKILL_CODE & c.CODE) > 0
HAVING 
    GRADE IS NOT NULL
ORDER BY 
    GRADE, ID;