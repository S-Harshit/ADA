package com.company;

public class Djkistra {



    public static void Djkistra(int a[][]) {



       int v = a.length;

        boolean visited[] = new boolean[v];

        int dist[] = new int[v];


        dist[0] = 0;

        for (int i = 1; i < v; i++) {
            dist[i] = 1000000;
        }



        for (int i = 0; i < v - 1; i++) {

            int minVertex = minVertex(dist, visited);
            visited[minVertex] = true;

            for (int j = 0; j < v; j++) {
                if (a[minVertex][j] != 0 && !visited[j] && dist[minVertex] != 99999999) {
                    int newDist = dist[minVertex] + a[minVertex][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                    }
                }
            }
        }


        System.out.println("Vertex \tDistance from source");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }



    }



    public static int minVertex(int[] distance, boolean visited[]) {



        int min = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (min == -1 || distance[i] < distance[min])) {
                min = i;
            }
        }
        return min;
    }



    public static void main(String[] args) {

        int a[][] = { { 0, 8, 0, 0, 0 }, { 0, 0, 0, 7, 1 }, { 0, 3, 0, 0, 0 }, { 0, 0, 3, 0, 0 }, { 2, 0, 0, 4, 0 } };


        Djkistra(a);
    }



}