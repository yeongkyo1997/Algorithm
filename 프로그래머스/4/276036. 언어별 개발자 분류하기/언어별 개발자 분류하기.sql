WITH SkillCodes AS (
    SELECT 
        MAX(CASE WHEN NAME = 'JavaScript' THEN CODE END) AS JavaScript,
        MAX(CASE WHEN NAME = 'React' THEN CODE END) AS React,
        MAX(CASE WHEN NAME = 'Vue' THEN CODE END) AS Vue,
        MAX(CASE WHEN NAME = 'Python' THEN CODE END) AS Python,
        MAX(CASE WHEN NAME = 'C#' THEN CODE END) AS CSharp
    FROM 
        SKILLCODES
),
DeveloperGrades AS (
    SELECT 
        d.ID,
        d.EMAIL,
        CASE
            WHEN (d.SKILL_CODE & sc.JavaScript > 0 OR d.SKILL_CODE & sc.React > 0 OR d.SKILL_CODE & sc.Vue > 0)
                 AND d.SKILL_CODE & sc.Python > 0 THEN 'A'
            WHEN d.SKILL_CODE & sc.CSharp > 0 THEN 'B'
            WHEN (d.SKILL_CODE & sc.JavaScript > 0 OR d.SKILL_CODE & sc.React > 0 OR d.SKILL_CODE & sc.Vue > 0) THEN 'C'
            ELSE NULL
        END AS GRADE
    FROM 
        DEVELOPERS d
    CROSS JOIN 
        SkillCodes sc
)
SELECT 
    GRADE, ID, EMAIL
FROM 
    DeveloperGrades
WHERE 
    GRADE IS NOT NULL
ORDER BY 
    GRADE, ID;