-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT *,
        lag(num) over(
            ORDER BY id
        ) AS before,
        lead(num) over(
            ORDER BY id
        ) AS
    AFTER
    FROM LOGS
)
SELECT DISTINCT num AS ConsecutiveNums
FROM subquery
WHERE num = before
    AND num =
AFTER