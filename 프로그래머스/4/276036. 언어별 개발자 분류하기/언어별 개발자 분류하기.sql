-- 코드를 작성해주세요

SELECT
    CASE
        WHEN (d.SKILL_CODE & fe.sum_code) > 0
             AND (d.SKILL_CODE & py.code) > 0 THEN 'A'
        WHEN (d.SKILL_CODE & cs.code) > 0 THEN 'B'
        WHEN (d.SKILL_CODE & fe.sum_code) > 0 THEN 'C'
    END AS GRADE,
    d.ID,
    d.EMAIL
FROM
    DEVELOPERS d
    CROSS JOIN (
        SELECT SUM(CODE) AS sum_code
        FROM SKILLCODES
        WHERE CATEGORY = 'Front End'
    ) fe
    CROSS JOIN (
        SELECT CODE
        FROM SKILLCODES
        WHERE NAME = 'Python'
    ) py
    CROSS JOIN (
        SELECT CODE
        FROM SKILLCODES
        WHERE NAME = 'C#'
    ) cs
WHERE
    (
        (d.SKILL_CODE & fe.sum_code) > 0
        AND (d.SKILL_CODE & py.code) > 0
    )
    OR (d.SKILL_CODE & cs.code) > 0
    OR (d.SKILL_CODE & fe.sum_code) > 0
ORDER BY
    GRADE ASC,
    ID ASC;