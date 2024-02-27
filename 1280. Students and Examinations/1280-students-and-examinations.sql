-- Write your PostgreSQL query statement below
SELECT
    Students.student_id,
    Students.student_name,
    Subjects.subject_name,
    count(Examinations.subject_name) AS attended_exams
FROM
    Students
    CROSS JOIN Subjects
    LEFT JOIN Examinations ON Students.student_id = Examinations.student_id
    AND Examinations.subject_name = Subjects.subject_name
GROUP BY
    1,
    2,
    3
ORDER BY
    1,
    3