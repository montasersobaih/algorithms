package com.montaser.algorithm.graph.shortest.path.dijkstra;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class DijkstraSPTest {

    private Dijkstra dijkstra;

    private static BufferedReader reader;

    @Before
    public void init() throws Exception {
        URL file = DijkstraSPTest.class.getResource("/dijkstra_input");
        Path filePath = Paths.get(Objects.requireNonNull(file).toURI());
        reader = Files.newBufferedReader(filePath);
    }

    @After
    public void destroy() throws Exception {
        reader.close();
    }


    @Test
    public void testAdjNormalDijkstra() throws Exception {
        dijkstra = new NormalDijkstra();

        String line;
        while (Objects.nonNull(line = reader.readLine())) {
            Map<Integer, List<Vertex>> adj = new HashMap<Integer, List<Vertex>>();

            StringTokenizer tokenizer = new StringTokenizer(line);
            int vertices = parseInt(tokenizer.nextToken());
            int edges = parseInt(tokenizer.nextToken());

            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < edges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = parseInt(tokenizer.nextToken());
                int to = parseInt(tokenizer.nextToken());
                int weight = parseInt(tokenizer.nextToken());

                if (set.add(from)) {
                    adj.put(from, new LinkedList<Vertex>());
                    adj.get(from).add(new Vertex(to, weight, Integer.MAX_VALUE));
                } else {
                    adj.get(from).add(new Vertex(to, weight, Integer.MAX_VALUE));
                }

                if (set.add(to)) {
                    adj.put(to, new LinkedList<Vertex>());
                    adj.get(to).add(new Vertex(from, weight, Integer.MAX_VALUE));
                } else {
                    adj.get(to).add(new Vertex(from, weight, Integer.MAX_VALUE));
                }
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int start = parseInt(tokenizer.nextToken());
            int end = parseInt(tokenizer.nextToken());

            long millis = System.currentTimeMillis();
            Vertex v = dijkstra.find(adj, start, end);
            double total = (System.currentTimeMillis() - millis) / 1000d;

            reader.readLine();//ignored space

            String resultDistance = String.format("The distance between %d and %d is --> %d", start, end, v.getMindis());
            String trueDistance = reader.readLine();
            System.out.println(resultDistance);
            Assert.assertEquals(resultDistance, trueDistance);

            String resultPath = String.format("The path is %s", v.getPath());
            String truePath = reader.readLine();
            System.out.println(resultPath);
            Assert.assertEquals(resultPath, truePath);

            System.out.printf("Execution time is %.5f second\n\n", total);

            reader.readLine();//ignored space
            reader.readLine();//ignored space
        }
    }

    @Test
    public void testMatrixNormalDijkstra() throws Exception {
        dijkstra = new NormalDijkstra();

        String line;
        while (Objects.nonNull(line = reader.readLine())) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int vertices = parseInt(tokenizer.nextToken());
            int edges = parseInt(tokenizer.nextToken());

            int[][] matrix = new int[vertices + 1][vertices + 1];
            for (int i = 0; i < edges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = parseInt(tokenizer.nextToken());
                int to = parseInt(tokenizer.nextToken());
                int weight = parseInt(tokenizer.nextToken());

                matrix[from][to] = weight;
                matrix[to][from] = weight;
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int start = parseInt(tokenizer.nextToken());
            int end = parseInt(tokenizer.nextToken());

            long millis = System.currentTimeMillis();
            Vertex v = dijkstra.find(matrix, start, end);
            double total = (System.currentTimeMillis() - millis) / 1000d;

            reader.readLine();//ignored space

            String resultDistance = String.format("The distance between %d and %d is --> %d", start, end, v.getMindis());
            String trueDistance = reader.readLine();
            System.out.println(resultDistance);
            Assert.assertEquals(resultDistance, trueDistance);

            String resultPath = String.format("The path is %s", v.getPath());
            String truePath = reader.readLine();
            System.out.println(resultPath);
            Assert.assertEquals(resultPath, truePath);

            System.out.printf("Execution time is %.5f second\n\n", total);

            reader.readLine();//ignored space
            reader.readLine();//ignored space
        }
    }

    @Test
    public void testAdjEnhancedDijkstra() throws Exception {
        dijkstra = new EnhancedDijkstra();

        String line;
        while (Objects.nonNull(line = reader.readLine())) {
            Map<Integer, List<Vertex>> adj = new HashMap<Integer, List<Vertex>>();

            StringTokenizer tokenizer = new StringTokenizer(line);
            int vertices = parseInt(tokenizer.nextToken());
            int edges = parseInt(tokenizer.nextToken());

            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < edges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = parseInt(tokenizer.nextToken());
                int to = parseInt(tokenizer.nextToken());
                int weight = parseInt(tokenizer.nextToken());

                if (set.add(from)) {
                    adj.put(from, new LinkedList<Vertex>());
                    adj.get(from).add(new Vertex(to, weight, Integer.MAX_VALUE));
                } else {
                    adj.get(from).add(new Vertex(to, weight, Integer.MAX_VALUE));
                }

                if (set.add(to)) {
                    adj.put(to, new LinkedList<Vertex>());
                    adj.get(to).add(new Vertex(from, weight, Integer.MAX_VALUE));
                } else {
                    adj.get(to).add(new Vertex(from, weight, Integer.MAX_VALUE));
                }
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int start = parseInt(tokenizer.nextToken());
            int end = parseInt(tokenizer.nextToken());

            long millis = System.currentTimeMillis();
            Vertex v = dijkstra.find(adj, start, end);
            double total = (System.currentTimeMillis() - millis) / 1000d;

            reader.readLine();//ignored space

            String resultDistance = String.format("The distance between %d and %d is --> %d", start, end, v.getMindis());
            String trueDistance = reader.readLine();
            System.out.println(resultDistance);
            Assert.assertEquals(resultDistance, trueDistance);

            String resultPath = String.format("The path is %s", v.getPath());
            String truePath = reader.readLine();
            System.out.println(resultPath);
            Assert.assertEquals(resultPath, truePath);

            System.out.printf("Execution time is %.5f second\n\n", total);

            reader.readLine();//ignored space
            reader.readLine();//ignored space
        }
    }

    @Test
    public void testMatrixEnhancedDijkstra() throws Exception {
        dijkstra = new NormalDijkstra();

        String line;
        while (Objects.nonNull(line = reader.readLine())) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int vertices = parseInt(tokenizer.nextToken());
            int edges = parseInt(tokenizer.nextToken());

            int[][] matrix = new int[vertices + 1][vertices + 1];
            for (int i = 0; i < edges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = parseInt(tokenizer.nextToken());
                int to = parseInt(tokenizer.nextToken());
                int weight = parseInt(tokenizer.nextToken());

                matrix[from][to] = weight;
                matrix[to][from] = weight;
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int start = parseInt(tokenizer.nextToken());
            int end = parseInt(tokenizer.nextToken());

            long millis = System.currentTimeMillis();
            Vertex v = dijkstra.find(matrix, start, end);
            double total = (System.currentTimeMillis() - millis) / 1000d;

            reader.readLine();//ignored space

            String resultDistance = String.format("The distance between %d and %d is --> %d", start, end, v.getMindis());
            String trueDistance = reader.readLine();
            System.out.println(resultDistance);
            Assert.assertEquals(resultDistance, trueDistance);

            String resultPath = String.format("The path is %s", v.getPath());
            String truePath = reader.readLine();
            System.out.println(resultPath);
            Assert.assertEquals(resultPath, truePath);

            System.out.printf("Execution time is %.5f second\n\n", total);

            reader.readLine();//ignored space
            reader.readLine();//ignored space
        }
    }
}
