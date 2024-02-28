-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
)
SELECT max(num) AS num
FROM subquery