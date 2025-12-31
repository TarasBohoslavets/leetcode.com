package Problem_List.Q690_Employee_Importance;

import java.util.*;


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}


class Solution {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		return dfs(map, id);
	}
	
	private int dfs(Map<Integer, Employee> map, int id) {
		Employee e = map.get(id);
		int total = e.importance;
		for (int subId : e.subordinates) {
			total += dfs(map, subId);
		}
		return total;
	}
}
