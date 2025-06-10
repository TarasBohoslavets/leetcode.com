package Problem_List.Q488_Zuma_Game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    // Клас для зберігання стану: дошка + кулі в руці
    class State {
        long board;
        long hand;

        public State(long board, long hand) {
            this.board = board;
            this.hand = hand;
        }

        // Перевизначення equals і hashCode для роботи в HashSet
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            State object = (State) o;
            return object.board == this.board && object.hand == this.hand;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = result * 31 + Long.hashCode(board);
            result = result * 31 + Long.hashCode(hand);
            return result;
        }
    }

    int max = 10; // максимальна кількість кроків (бо всього 5 куль)

    public int findMinStep(String boardString, String handString) {
        long hand = encodeHand(handString);   // закодувати руку
        long board = encodeBoard(boardString); // закодувати дошку
        Set<State> isVisited = new HashSet<>(); // множина для відстеження відвіданих станів
        dfs(board, hand, 0, isVisited);        // запуск пошуку в глибину
        return max == 10 ? -1 : max;           // якщо не знайшли рішення — повертаємо -1
    }

    // Рекурсивна функція DFS
    private void dfs(long board, long hand, int curr, Set<State> isVisited) {
        if (board == 0) {
            max = Math.min(max, curr); // всі кулі знищено — оновлюємо мінімум
        }
        if (curr >= max || hand == 0 || !isVisited.add(new State(board, hand))) {
            return; // обрізання пошуку
        }

        for (int i = 0; i < 64; i += 3) { // позиція вставки кулі на дошці
            long boardBall = (board >> i) & 7;
            long nextBoardBall = (board >> (i + 3)) & 7;
            long prevBoardBall = i == 0 ? 0 : (board >> (i - 3)) & 7;

            for (int j = 0; j < 16; j += 3) { // перебір кожної кулі в руці
                long currBall = (hand >> j) & 7;
                if (currBall == 0) break;

                long prevBall = j == 0 ? 0 : (hand >> (j - 3)) & 7;
                long newHand = ((hand >> (j + 3)) << j) | (hand & ((1 << j) - 1));

                // Пропустити повторення, непридатні вставки та невигідні ходи
                if (currBall == prevBall) continue;
                if (currBall == prevBoardBall) continue;
                if ((curr != 0 && currBall != boardBall) ||
                        (curr == 0 && currBall != boardBall && boardBall != prevBoardBall)) continue;

                // Вставити кулю в позицію i
                long newBoard = (board & ((1L << i) - 1)) | (currBall << i) | ((board >> i) << (i + 3));

                // Якщо після вставки утворилася трійка — обрізаємо
                if (currBall == boardBall && currBall == nextBoardBall) {
                    newBoard = trim(newBoard);
                }

                dfs(newBoard, newHand, curr + 1, isVisited); // рекурсивно викликаємо
            }

            if (boardBall == 0) break; // кінець дошки
        }
    }

    // Функція, яка знищує трійки однакових куль на дошці
    private long trim(long board) {
        long stack = 0;
        for (int i = 0; i < 64; i += 3) {
            long currBall = (board >> i) & 7;
            long top = stack & 7;
            // якщо три однакові кулі — видаляємо
            if (top != 0 && currBall != top && (stack & 63) == ((stack >> 3) & 63)) {
                stack >>= 9;
                while ((stack & 7) == top) {
                    stack >>= 3;
                }
            }
            if (currBall == 0) break;
            stack = (stack << 3) | currBall;
        }
        return stack;
    }

    // Кодування дошки в 64-бітне число
    private long encodeBoard(String board) {
        long boardEncoded = 0;
        for (int i = 0; i < board.length(); i++) {
            boardEncoded = (boardEncoded << 3) | encodeChar(board.charAt(i));
        }
        return boardEncoded;
    }

    // Кодування руки в 64-бітне число з попереднім сортуванням
    private long encodeHand(String hand) {
        long[] handEncoded = new long[hand.length()];
        for (int i = 0; i < hand.length(); i++) {
            handEncoded[i] = encodeChar(hand.charAt(i));
        }
        Arrays.sort(handEncoded); // важливо для унікальності станів
        long result = 0;
        for (long ball : handEncoded) {
            result = (result << 3) | ball;
        }
        return result;
    }

    // Кодування символів куль у числа
    private long encodeChar(char ch) {
        return switch (ch) {
            case 'R' -> 1;
            case 'Y' -> 2;
            case 'B' -> 3;
            case 'G' -> 4;
            case 'W' -> 5;
            default -> throw new IllegalArgumentException();
        };
    }

    // Декодування чисел у символи (не використовується у вирішенні)
    private char decodeChar(long ch) {
        return switch ((int) ch) {
            case 1 -> 'R';
            case 2 -> 'Y';
            case 3 -> 'B';
            case 4 -> 'G';
            case 5 -> 'W';
            default -> throw new IllegalArgumentException();
        };
    }
}