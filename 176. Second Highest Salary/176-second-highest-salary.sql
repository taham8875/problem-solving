-- Write your PostgreSQL query statement below
SELECT CASE
        WHEN (
            SELECT COUNT(DISTINCT salary) > 1
            FROM Employee
        ) THEN (
            SELECT DISTINCT salary
            FROM Employee
            ORDER BY salary DESC OFFSET 1
            LIMIT 1
        )
        ELSE NULL
    END AS SecondHighestSalary