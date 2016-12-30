package codeReview.graph;

import java.util.*;

/**
 * Created by wangdong on 4/30/16.
 */
public class Itinerary {

    public List<String> findItinerary1(String[][] tickets) {
        List<String> connection = new ArrayList<>();
        if(tickets == null || tickets.length == 0) {
            return connection;
        }

        Map<String, List<String>> itineraries = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            itineraries.putIfAbsent(ticket[0], new ArrayList<>());
            itineraries.get(ticket[0]).add(ticket[1]);
        }

        String from = "JFK";
        connection.add(from);
        while (itineraries.containsKey(from) && itineraries.get(from).size() > 0) {
            List<String> destinations = itineraries.get(from);
            destinations.sort(String::compareTo);

            from = destinations.remove(0);
            connection.add(from);
        }

        return connection;
    }

    private static class vertex<T> {
        private T value;
        private List<Edge<T>> edges;

        public vertex() {
            value = null;
            edges = new ArrayList<>();
        }

        public T getValue() {
            return value;
        }

        public List getEdges() {
            return edges;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }
    }

    private static class Edge<T> {
        public T getEndVertexValue() {
            return endVertexValue;
        }

        public void setEndVertexValue(T endVertexValue) {
            this.endVertexValue = endVertexValue;
        }

        private T endVertexValue;


    }
    public List<String> findItinerary(String[][] tickets){
        if(tickets == null || tickets.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> adjacentList = new HashMap<>();
        for(String[] ticket : tickets) {
            adjacentList.putIfAbsent(ticket[0], new ArrayList<>());
            adjacentList.get(ticket[0]).add(ticket[1]);
        }

        adjacentList.values().stream().forEach(destinations -> destinations.sort(String::compareTo));

        String start = "JFK";

        return dfsWithRoundTripFirst(adjacentList, start);
    }

    private List<String> dfsWithRoundTripFirst(Map<String, List<String>> adjacentList, String start){
        if(adjacentList.get(start) == null) {
            return Arrays.asList(start);
        }
        List<String> roundTrip = new ArrayList<>();
        List<String> oneWay = new ArrayList<>();
        Iterator iterator = adjacentList.get(start).iterator();

        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            iterator.remove();
            List<String> dfsTrip = dfsWithRoundTripFirst(adjacentList, next);
            if(dfsTrip.contains(start)) {
                roundTrip.addAll(dfsTrip);
            } else {
                oneWay.addAll(dfsTrip);
            }
        }

        List<String> path = new ArrayList<>();
        path.add(start);
        path.addAll(roundTrip);
        path.addAll(oneWay);

        return path;
    }

}
