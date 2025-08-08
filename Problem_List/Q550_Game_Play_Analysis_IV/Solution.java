package Problem_List.Q550_Game_Play_Analysis_IV;

public class Solution {

    /*
    -- Знаходимо першу дату входу для кожного гравця
WITH FirstLogin AS (
    SELECT
        player_id,
        MIN(event_date) AS first_date  -- мінімальна дата входу = перший вхід
    FROM Activity
    GROUP BY player_id
),

-- Перевіряємо, чи гравець зайшов наступного дня після першого входу
NextDayLogin AS (
    SELECT DISTINCT a.player_id  -- DISTINCT гарантує, що кожен гравець враховується лише один раз
    FROM Activity a
    JOIN FirstLogin f
      ON a.player_id = f.player_id
     AND a.event_date = f.first_date + INTERVAL '1 day'  -- перевірка входу на наступний день
)

-- Обчислюємо частку гравців, які зайшли наступного дня
SELECT
    ROUND(
        COUNT(NextDayLogin.player_id) * 1.0 / COUNT(FirstLogin.player_id), 2  -- ділимо кількість гравців, які зайшли наступного дня, на загальну кількість гравців
    ) AS fraction
FROM FirstLogin
LEFT JOIN NextDayLogin
  ON FirstLogin.player_id = NextDayLogin.player_id;  -- LEFT JOIN дозволяє врахувати всіх гравців, навіть тих, хто не заходив наступного дня

    */

}
