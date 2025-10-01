package Problem_List.Q602_Friend_Requests_II_Who_Has_the_Most_Friends;

public class Solution {
	/*
	-- Write your PostgreSQL query statement below
SELECT id, COUNT(DISTINCT friend_id) AS num
FROM (
    SELECT requester_id AS id, accepter_id AS friend_id
    FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id, requester_id AS friend_id
    FROM RequestAccepted
) AS friends
GROUP BY id
ORDER BY num DESC, id ASC
LIMIT 1;
	 */
}
