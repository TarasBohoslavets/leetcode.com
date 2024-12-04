package Problem_List.Q165_Compare_Version_Numbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        // Розділяємо рядки на частини за роздільником "."
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        // Знаходимо максимальну довжину між обома версіями
        int maxLength = Math.max(v1Parts.length, v2Parts.length);

        // Порівнюємо кожну ревізію
        for (int i = 0; i < maxLength; i++) {
            // Якщо ревізія відсутня, вважаємо її рівною 0
            int rev1 = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int rev2 = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            // Порівнюємо поточні ревізії
            if (rev1 > rev2) {
                return 1; // Перша версія більша
            } else if (rev1 < rev2) {
                return -1; // Друга версія більша
            }
        }

        // Якщо всі ревізії рівні, версії однакові
        return 0;
    }

    // Метод для запуску прикладів
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println("Приклад 1:");
        System.out.println("version1: " + version1 + ", version2: " + version2);
        System.out.println("Результат: " + solution.compareVersion(version1, version2));
        System.out.println();

        // Приклад 2
        version1 = "1.01";
        version2 = "1.001";
        System.out.println("Приклад 2:");
        System.out.println("version1: " + version1 + ", version2: " + version2);
        System.out.println("Результат: " + solution.compareVersion(version1, version2));
        System.out.println();

        // Приклад 3
        version1 = "1.0";
        version2 = "1.0.0.0";
        System.out.println("Приклад 3:");
        System.out.println("version1: " + version1 + ", version2: " + version2);
        System.out.println("Результат: " + solution.compareVersion(version1, version2));
        System.out.println();

        // Приклад 4 (Додатковий)
        version1 = "2.0";
        version2 = "2.0.1";
        System.out.println("Приклад 4:");
        System.out.println("version1: " + version1 + ", version2: " + version2);
        System.out.println("Результат: " + solution.compareVersion(version1, version2));
    }
}
