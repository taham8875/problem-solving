-- Write your PostgreSQL query statement below
-- with `HAVING` clause
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;
-- with subquery
WITH subquery AS (
    SELECT COUNT(student) AS number_of_students,
        class
    FROM Courses
    GROUP BY class
)
SELECT class
FROM subquery
WHERE number_of_students >= 5;