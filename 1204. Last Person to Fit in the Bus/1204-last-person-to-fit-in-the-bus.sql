-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT *,
        sum(weight) over (
            ORDER BY turn
        ) AS accumulative_weight
    FROM Queue
    ORDER BY turn
)
SELECT person_name
FROM subquery
WHERE accumulative_weight <= 1000
ORDER BY accumulative_weight DESC
LIMIT 1