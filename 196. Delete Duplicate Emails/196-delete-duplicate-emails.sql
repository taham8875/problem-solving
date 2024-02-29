-- Write your PostgreSQL query statement below
DELETE FROM Person
WHERE Id IN (
        SELECT p1.Id
        FROM Person p1
            CROSS JOIN Person p2
        WHERE p1.Email = p2.Email
            AND p1.Id > p2.Id
    );