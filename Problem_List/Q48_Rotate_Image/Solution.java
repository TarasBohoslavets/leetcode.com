package Problem_List.Q48_Rotate_Image;
/*
Щоб розв'язати задачу обертання зображення (матриці) на 90 градусів за годинниковою стрілкою,
слід виконати обертання на місці, тобто без створення додаткових матриць.
Це завдання передбачає дві основні операції:
1.Транспонування матриці: Замінюємо рядки на стовпці.
2.Заміна рядків: Відображаємо кожен рядок відносно середньої вертикальної осі
Транспонування:

Після цього кроку елементи матриці обертаються таким чином, що кожен елемент,
який знаходиться на позиції [i][j], переміщується на позицію [j][i].

Відображення рядків:
Після транспонування рядки мають бути відображені, щоб отримати остаточне обертання на 90 градусів за годинниковою стрілкою.
Це робиться шляхом обміну першого і останнього елементів у кожному рядку, потім другого і передостаннього, і так далі.

* */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Транспонування матриці
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Відображення рядків
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
