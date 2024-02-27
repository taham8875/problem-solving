-- Write your PostgreSQL query statement below
-- I don't know wtf i did here, but a better solution is below
WITH subquery AS (
    SELECT
        Signups.user_id,
        Confirmations.action,
        (
            sum(
                CASE
                    WHEN ACTION = 'confirmed' THEN 1
                    WHEN ACTION = 'timeout'
                    OR ACTION IS NULL THEN 1
                    ELSE 0
                END
            )
        ) AS action_count
    FROM
        Signups
        LEFT JOIN Confirmations ON Signups.user_id = Confirmations.user_id
    GROUP BY
        Signups.user_id,
        Confirmations.action
)
SELECT
    user_id,
    (
        round(
            sum(
                CASE
                    WHEN ACTION = 'confirmed' THEN action_count
                    ELSE 0
                END
            ) / sum(action_count),
            2
        )
    ) AS confirmation_rate
FROM
    subquery
GROUP BY
    user_id;

---------------------------------------------
-- Write your PostgreSQL query statement below
-- with join
SELECT
    Signups.user_id,
    round(
        avg(
            CASE
                WHEN Confirmations.action = 'confirmed' THEN 1
                ELSE 0
            END
        ),
        2
    ) AS confirmation_rate
FROM
    Signups
    LEFT JOIN Confirmations ON Signups.user_id = Confirmations.user_id
GROUP BY
    Signups.user_id;