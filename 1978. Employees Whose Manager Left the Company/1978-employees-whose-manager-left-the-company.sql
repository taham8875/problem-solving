-- Write your PostgreSQL query statement below
WITH employees_with_managers AS (
    SELECT *
    FROM Employees
    WHERE manager_id IS NOT NULL
)
SELECT e1.employee_id
FROM employees_with_managers e1
    LEFT JOIN Employees e2 ON e1.manager_id = e2.employee_id
WHERE e2.employee_id IS NULL
    AND e1.salary < 30000
ORDER BY e1.employee_id