-- Write your PostgreSQL query statement below
-- Fast | Simple
SELECT 'Low Salary' AS category,
    sum(
        CASE
            WHEN income < 20000 THEN 1
            ELSE 0
        END
    ) AS accounts_count
FROM Accounts
UNION
SELECT 'Average Salary' AS category,
    sum(
        CASE
            WHEN income >= 20000
            AND income <= 50000 THEN 1
            ELSE 0
        END
    ) AS accounts_count
FROM Accounts
UNION
SELECT 'High Salary' AS category,
    sum(
        CASE
            WHEN income > 50000 THEN 1
            ELSE 0
        END
    ) AS accounts_count
FROM Accounts;
-- Slow | Bad
WITH subquery AS (
    SELECT *,
        (
            CASE
                WHEN income < 20000 THEN 'Low Salary'
                WHEN income >= 20000
                AND income <= 50000 THEN 'Average Salary'
                WHEN income > 50000 THEN 'High Salary'
            END
        ) AS category
    FROM Accounts
),
categories AS (
    -- create table with 'low salary', 'average salary', 'high salary' categories
    SELECT 'Low Salary' AS category
    UNION
    SELECT 'Average Salary' AS category
    UNION
    SELECT 'High Salary' AS category
)
SELECT categories.category,
    COUNT (subquery.category) AS accounts_count
FROM subquery
    RIGHT JOIN categories ON categories.category = subquery.category
GROUP BY categories.category;