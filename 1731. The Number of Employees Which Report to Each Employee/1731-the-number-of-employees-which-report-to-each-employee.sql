-- Write your PostgreSQL query statement below
SELECT e2.employee_id,
    e2.name,
    COUNT(e2.employee_id) AS reports_count,
    avg(e1.age)::int AS average_age
FROM Employees e1
    JOIN Employees e2 ON e1.reports_to = e2.employee_id
GROUP BY e2.employee_id,
    e2.name
ORDER BY e2.employee_id