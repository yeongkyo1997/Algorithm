SELECT
    COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE
    (GENOTYPE & 2) = 0       -- 2번 형질이 없는 경우
    AND (
        (GENOTYPE & 1) = 1   -- 1번 형질이 있거나
        OR
        (GENOTYPE & 4) = 4   -- 3번 형질이 있는 경우
    );
