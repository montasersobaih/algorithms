package com.montaser.algorithm.graph.shortest.path.dijkstra;

import com.montaser.algorithm.graph.traversals.breadth.first.search.UWDGraphCharacterTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import static com.montaser.algorithm.graph.ResourcePath.INPUT;
import static com.montaser.algorithm.graph.ResourcePath.OUTPUT;
import static com.montaser.algorithm.graph.ResourcePath.WEIGHTED_UNDIRECTED_GRAPH;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Dijkstra
 * @since 15-11-2022
 */

@SuppressWarnings("unchecked")
public final class WUDGDijkstraNormalCharacterTest {

    private static final String INPUT_DIRECTORY = INPUT.concat(WEIGHTED_UNDIRECTED_GRAPH);

    private static final String OUTPUT_DIRECTORY = OUTPUT.concat(WEIGHTED_UNDIRECTED_GRAPH).concat("/dijkstra");

    private final Dijkstra<Integer> dijkstra = new DijkstraNormalIntegerImpl();

    private static BufferedReader input;

    private static BufferedReader output;

    @Before
    public void init() throws Exception {
        URL inputPath = UWDGraphCharacterTest.class.getResource(INPUT_DIRECTORY.concat("/character.input"));
        URL outputPath = UWDGraphCharacterTest.class.getResource(OUTPUT_DIRECTORY.concat("/character.output"));

        input = Files.newBufferedReader(Paths.get(inputPath.toURI()));
        output = Files.newBufferedReader(Paths.get(outputPath.toURI()));
    }

    @After
    public void destroy() throws Exception {
        input.close();
        output.close();
    }

    @Test
    public void findTheShortestPathBetweenTwoVerticesUsingMatrix() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);

            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            Integer[][] adjacency = new Integer[vNumber][vNumber];
            for (Integer[] integers : adjacency) {
                Arrays.fill(integers, 0);
            }

            for (int i = 0; i < eNumber; i++) {
                tokenizer = new StringTokenizer(input.readLine());

                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';
                int weight = Integer.parseInt(tokenizer.nextToken());

                adjacency[from][dest] = weight;
            }

            tokenizer = new StringTokenizer(input.readLine());

            char start = tokenizer.nextToken().charAt(0);
            char dest = tokenizer.nextToken().charAt(0);

            input.readLine();//ignored the dashed line

            Path<Integer> result = dijkstra.find(adjacency, start - 'A', dest - 'A');

            StringJoiner joiner = new StringJoiner(" -> ");

            tokenizer = new StringTokenizer(result.getPath(), " -> ");
            while (tokenizer.hasMoreTokens()) {
                int vertex = Integer.parseInt(tokenizer.nextToken()) + 'A';
                joiner.add(Character.toString((char) vertex));
            }

            String fMessage = "The distance between %c and %c is --> %d, The path is %s";
            Assert.assertEquals(String.format(fMessage, start, dest, result.getDistance(), joiner), expected);
        }
    }

    @Test
    public void findTheShortestPathBetweenTwoVerticesUsingArrayOfList() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);

            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            List<Edge<Integer>>[] adjacency = new List[vNumber];

            for (int i = 0; i < vNumber; i++) {
                adjacency[i] = new LinkedList<>();
            }

            for (int i = 0; i < eNumber; i++) {
                tokenizer = new StringTokenizer(input.readLine());

                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';
                int weight = Integer.parseInt(tokenizer.nextToken());

                adjacency[from].add(new Edge<>(dest, weight));
            }

            tokenizer = new StringTokenizer(input.readLine());

            char start = tokenizer.nextToken().charAt(0);
            char dest = tokenizer.nextToken().charAt(0);

            input.readLine();//ignored the dashed line

            Path<Integer> result = dijkstra.find(adjacency, start - 'A', dest - 'A');

            StringJoiner joiner = new StringJoiner(" -> ");

            tokenizer = new StringTokenizer(result.getPath(), " -> ");
            while (tokenizer.hasMoreTokens()) {
                int vertex = Integer.parseInt(tokenizer.nextToken()) + 'A';
                joiner.add(Character.toString((char) vertex));
            }

            String fMessage = "The distance between %c and %c is --> %d, The path is %s";
            Assert.assertEquals(String.format(fMessage, start, dest, result.getDistance(), joiner), expected);
        }
    }

    @Test
    public void findTheShortestPathBetweenTwoVerticesUsingListOfList() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);

            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            List<List<Edge<Integer>>> adjacency = new LinkedList<>();
            for (int i = 0; i < vNumber; i++) {
                adjacency.add(new LinkedList<>());
            }

            for (int i = 0; i < eNumber; i++) {
                tokenizer = new StringTokenizer(input.readLine());

                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';
                int weight = Integer.parseInt(tokenizer.nextToken());

                adjacency.get(from).add(new Edge<>(dest, weight));
            }

            tokenizer = new StringTokenizer(input.readLine());

            char start = tokenizer.nextToken().charAt(0);
            char dest = tokenizer.nextToken().charAt(0);

            input.readLine();//ignored the dashed line

            Path<Integer> result = dijkstra.find(adjacency, start - 'A', dest - 'A');

            StringJoiner joiner = new StringJoiner(" -> ");

            tokenizer = new StringTokenizer(result.getPath(), " -> ");
            while (tokenizer.hasMoreTokens()) {
                int vertex = Integer.parseInt(tokenizer.nextToken()) + 'A';
                joiner.add(Character.toString((char) vertex));
            }

            String fMessage = "The distance between %c and %c is --> %d, The path is %s";
            Assert.assertEquals(String.format(fMessage, start, dest, result.getDistance(), joiner), expected);
        }
    }

    @Test
    public void findTheShortestPathBetweenTwoVerticesUsingMapOfList() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);

            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            Map<Integer, List<Edge<Integer>>> adjacency = new HashMap<>();

            for (int i = 0; i < eNumber; i++) {
                tokenizer = new StringTokenizer(input.readLine());

                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';
                int weight = Integer.parseInt(tokenizer.nextToken());

                if (!adjacency.containsKey(from)) {
                    adjacency.put(from, new LinkedList<>());
                }

                adjacency.get(from).add(new Edge<>(dest, weight));
            }

            tokenizer = new StringTokenizer(input.readLine());

            char start = tokenizer.nextToken().charAt(0);
            char dest = tokenizer.nextToken().charAt(0);

            input.readLine();//ignored the dashed line

            Path<Integer> result = dijkstra.find(adjacency, start - 'A', dest - 'A');

            StringJoiner joiner = new StringJoiner(" -> ");

            tokenizer = new StringTokenizer(result.getPath(), " -> ");
            while (tokenizer.hasMoreTokens()) {
                int vertex = Integer.parseInt(tokenizer.nextToken()) + 'A';
                joiner.add(Character.toString((char) vertex));
            }

            String fMessage = "The distance between %c and %c is --> %d, The path is %s";
            Assert.assertEquals(String.format(fMessage, start, dest, result.getDistance(), joiner), expected);
        }
    }
}
