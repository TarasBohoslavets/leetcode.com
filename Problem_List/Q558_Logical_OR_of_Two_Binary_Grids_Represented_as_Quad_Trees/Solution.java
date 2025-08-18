package Problem_List.Q558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        // Якщо один з вузлів — лист
        if (quadTree1.isLeaf) {
            if (quadTree1.val) return new Node(true, true, null, null, null, null);
            return clone(quadTree2);
        }

        if (quadTree2.isLeaf) {
            if (quadTree2.val) return new Node(true, true, null, null, null, null);
            return clone(quadTree1);
        }

        // Рекурсивне об'єднання дочірніх вузлів
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        // Якщо всі дочірні — листи з однаковим значенням, об'єднуємо їх
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val &&
                topLeft.val == bottomLeft.val &&
                topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        // Інакше — створюємо внутрішній вузол
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // Клонування вузла (щоб уникнути мутацій)
    private Node clone(Node node) {
        if (node == null) return null;
        if (node.isLeaf) return new Node(node.val, true, null, null, null, null);
        return new Node(node.val, false,
                clone(node.topLeft),
                clone(node.topRight),
                clone(node.bottomLeft),
                clone(node.bottomRight));
    }
}
