-- Write your PostgreSQL query statement below
SELECT Project.project_id,
    round(avg(Employee.experience_years), 2) AS average_years
FROM Project
    JOIN Employee ON Project.employee_id = Employee.employee_id
GROUP BY Project.project_id