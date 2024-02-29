-- Write your PostgreSQL query statement below
WITH subquery AS (
    SELECT Employee.name AS Employee,
        salary,
        Department.name AS Department,
        dense_rank() over(
            PARTITION BY departmentid
            ORDER BY salary DESC
        ) AS dense_rank
    FROM Employee
        JOIN Department ON Employee.departmentId = Department.id
)
SELECT Department,
    Employee,
    salary
FROM subquery
WHERE dense_rank < 4