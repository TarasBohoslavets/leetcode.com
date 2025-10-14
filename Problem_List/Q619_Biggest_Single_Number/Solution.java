package Problem_List.Q619_Biggest_Single_Number;

public class Solution {
	/*
	-- Write your PostgreSQL query statement below
SELECT MAX(num) AS num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
) AS singles;
	 */
}
