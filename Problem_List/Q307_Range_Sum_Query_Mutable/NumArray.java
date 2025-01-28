package Problem_List.Q307_Range_Sum_Query_Mutable;

class NumArray {

    private int[] segmentTree; // Масив для збереження сегментного дерева
    private int n; // Розмір вхідного масиву

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n]; // Виділяємо пам'ять для сегментного дерева
        buildSegmentTree(nums, 0, 0, n - 1); // Побудова дерева
    }

    // Побудова сегментного дерева
    private void buildSegmentTree(int[] nums, int treeIndex, int start, int end) {
        if (start == end) {
            segmentTree[treeIndex] = nums[start]; // Якщо це лист, записуємо значення
            return;
        }

        int mid = start + (end - start) / 2; // Середина відрізка
        int leftChild = 2 * treeIndex + 1;  // Індекс лівого піддерева
        int rightChild = 2 * treeIndex + 2; // Індекс правого піддерева

        // Рекурсивно будуємо ліве і праве піддерево
        buildSegmentTree(nums, leftChild, start, mid);
        buildSegmentTree(nums, rightChild, mid + 1, end);

        // Вузол дерева дорівнює сумі значень його дітей
        segmentTree[treeIndex] = segmentTree[leftChild] + segmentTree[rightChild];
    }

    // Оновлення елемента в сегментному дереві
    public void update(int index, int val) {
        updateSegmentTree(0, 0, n - 1, index, val);
    }

    private void updateSegmentTree(int treeIndex, int start, int end, int index, int val) {
        if (start == end) {
            segmentTree[treeIndex] = val; // Оновлюємо значення листа
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;

        // Якщо індекс знаходиться в лівій частині
        if (index <= mid) {
            updateSegmentTree(leftChild, start, mid, index, val);
        } else { // Якщо в правій частині
            updateSegmentTree(rightChild, mid + 1, end, index, val);
        }

        // Оновлюємо значення поточного вузла
        segmentTree[treeIndex] = segmentTree[leftChild] + segmentTree[rightChild];
    }

    // Запит суми на відрізку [left, right]
    public int sumRange(int left, int right) {
        return querySegmentTree(0, 0, n - 1, left, right);
    }

    private int querySegmentTree(int treeIndex, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return 0; // Якщо відрізок поза межами запиту
        }

        if (start >= left && end <= right) {
            return segmentTree[treeIndex]; // Якщо відрізок повністю входить у запит
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;

        // Рекурсивно отримуємо суми лівої і правої частини
        int leftSum = querySegmentTree(leftChild, start, mid, left, right);
        int rightSum = querySegmentTree(rightChild, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}

