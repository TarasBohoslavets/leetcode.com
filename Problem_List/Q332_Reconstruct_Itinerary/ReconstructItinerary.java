package Problem_List.Q332_Reconstruct_Itinerary;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Крок 1: Побудова графа у вигляді мапи суміжності (TreeMap для сортування)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> itinerary = new LinkedList<>();

        // Крок 2: Використання DFS для обходу графа
        dfs("JFK", graph, itinerary);

        // Крок 3: Оскільки маршрут записано у зворотному порядку, потрібно його перевернути
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);

        // Проходимо по всіх доступних рейсах у лексикографічному порядку
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, itinerary);
        }

        // Додаємо аеропорт у маршрут (у зворотному порядку)
        itinerary.add(airport);
    }

    public static void main(String[] args) {
        ReconstructItinerary solver = new ReconstructItinerary();

        List<List<String>> tickets1 = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );

        List<List<String>> tickets2 = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );

        System.out.println(solver.findItinerary(tickets1));
        // Вихід: ["JFK", "MUC", "LHR", "SFO", "SJC"]

        System.out.println(solver.findItinerary(tickets2));
        // Вихід: ["JFK", "ATL", "JFK", "SFO", "ATL", "SFO"]
    }
}

