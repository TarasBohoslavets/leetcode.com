package Problem_List.Q341_Flatten_Nested_List_Iterator;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flattenedList;
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<>();
        flatten(nestedList);
        iterator = flattenedList.iterator();
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                flattenedList.add(ni.getInteger());
            } else {
                flatten(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

