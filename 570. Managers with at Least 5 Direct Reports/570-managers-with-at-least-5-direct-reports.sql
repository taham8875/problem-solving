-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT
        e1.id,
        e1.name,
        count(e1.id) over(PARTITION by e1.id) AS manager_count
    FROM
        Employee e1
        JOIN Employee e2 ON e1.id = e2.managerId
)
SELECT
    name
FROM
    subquery
WHERE
    manager_count >= 5
GROUP BY
    id,
    name