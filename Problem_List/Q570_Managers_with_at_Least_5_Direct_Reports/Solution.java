package Problem_List.Q570_Managers_with_at_Least_5_Direct_Reports;

public class Solution {
	
	/*
	# Write your MySQL query statement below
SELECT name
FROM Employee
WHERE id IN (
    SELECT managerId
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
);
	 */
}
