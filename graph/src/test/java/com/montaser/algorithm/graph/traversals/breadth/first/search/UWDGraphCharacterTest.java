package com.montaser.algorithm.graph.traversals.breadth.first.search;

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
import static com.montaser.algorithm.graph.ResourcePath.UNWEIGHTED_DIRECTED_GRAPH;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Breadth First Search (BFS)
 * @since 10-11-2022
 */

@SuppressWarnings("unchecked")
public final class UWDGraphCharacterTest {

    private static final String INPUT_DIRECTORY = INPUT.concat(UNWEIGHTED_DIRECTED_GRAPH);

    private static final String OUTPUT_DIRECTORY = OUTPUT.concat(UNWEIGHTED_DIRECTED_GRAPH).concat("/bfs");

    private final Bfs<Integer> bfs = new BfsIterableIntegerImpl();

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
    public void findAllReachableVerticesStartingFromSpecificVertexUsingMatrix() throws Exception {
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

            while (eNumber-- > 0) {
                tokenizer = new StringTokenizer(input.readLine());
                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';

                adjacency[from][dest] = 1;
            }

            char start = input.readLine().charAt(0);
            String result = bfs.find(adjacency, start - 'A');

            input.readLine();//ignored the dashed line

            StringJoiner joiner = new StringJoiner(", ", "[", "]");

            tokenizer = new StringTokenizer(result);
            tokenizer.nextToken();//skipping the start vertex
            while (tokenizer.hasMoreTokens()) {
                int vertex = tokenizer.nextToken().charAt(0) - '0';
                joiner.add(Character.toString((char) (vertex + 'A')));
            }

            String formattedMessage = "All reachable vertices from vertex %c are:- %s";
            Assert.assertEquals(String.format(formattedMessage, start, joiner).trim(), expected);
        }
    }

    @Test
    public void findAllReachableVerticesStartingFromSpecificVertexUsingArrayOfList() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);
            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            List<Integer>[] adjacency = new List[vNumber];
            for (int i = 0; i < vNumber; i++) {
                adjacency[i] = new LinkedList<>();
            }

            while (eNumber-- > 0) {
                tokenizer = new StringTokenizer(input.readLine());
                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';

                adjacency[from].add(dest);
            }

            char start = input.readLine().charAt(0);
            String result = bfs.find(adjacency, start - 'A');

            input.readLine();//ignored the dashed line

            StringJoiner joiner = new StringJoiner(", ", "[", "]");

            tokenizer = new StringTokenizer(result);
            tokenizer.nextToken();//skipping the start vertex
            while (tokenizer.hasMoreTokens()) {
                int vertex = tokenizer.nextToken().charAt(0) - '0';
                joiner.add(Character.toString((char) (vertex + 'A')));
            }

            String formattedMessage = "All reachable vertices from vertex %c are:- %s";
            Assert.assertEquals(String.format(formattedMessage, start, joiner).trim(), expected);
        }
    }

    @Test
    public void findAllReachableVerticesStartingFromSpecificVertexUsingListOfList() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);
            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            List<List<Integer>> adjacency = new LinkedList<>();
            for (int i = 0; i < vNumber; i++) {
                adjacency.add(new LinkedList<>());
            }

            while (eNumber-- > 0) {
                tokenizer = new StringTokenizer(input.readLine());
                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';

                adjacency.get(from).add(dest);
            }

            char start = input.readLine().charAt(0);
            String result = bfs.find(adjacency, start - 'A');

            input.readLine();//ignored the dashed line

            StringJoiner joiner = new StringJoiner(", ", "[", "]");

            tokenizer = new StringTokenizer(result);
            tokenizer.nextToken();//skipping the start vertex
            while (tokenizer.hasMoreTokens()) {
                int vertex = tokenizer.nextToken().charAt(0) - '0';
                joiner.add(Character.toString((char) (vertex + 'A')));
            }

            String formattedMessage = "All reachable vertices from vertex %c are:- %s";
            Assert.assertEquals(String.format(formattedMessage, start, joiner).trim(), expected);
        }
    }

    @Test
    public void findAllReachableVerticesStartingFromSpecificVertexUsingMapOfList() throws Exception {
        StringTokenizer tokenizer;

        String line, expected;
        while (Objects.nonNull(line = input.readLine()) && Objects.nonNull(expected = output.readLine())) {
            tokenizer = new StringTokenizer(line);
            int vNumber = Integer.parseInt(tokenizer.nextToken());
            int eNumber = Integer.parseInt(tokenizer.nextToken());

            Map<Integer, List<Integer>> adjacency = new HashMap<>();

            while (eNumber-- > 0) {
                tokenizer = new StringTokenizer(input.readLine());
                int from = tokenizer.nextToken().charAt(0) - 'A';
                int dest = tokenizer.nextToken().charAt(0) - 'A';

                if (!adjacency.containsKey(from)) {
                    adjacency.put(from, new LinkedList<>());
                }

                adjacency.get(from).add(dest);
            }

            char start = input.readLine().charAt(0);
            String result = bfs.find(adjacency, start - 'A');

            input.readLine();//ignored the dashed line

            StringJoiner joiner = new StringJoiner(", ", "[", "]");

            tokenizer = new StringTokenizer(result);
            tokenizer.nextToken();//skipping the start vertex
            while (tokenizer.hasMoreTokens()) {
                int vertex = tokenizer.nextToken().charAt(0) - '0';
                joiner.add(Character.toString((char) (vertex + 'A')));
            }

            String formattedMessage = "All reachable vertices from vertex %c are:- %s";
            Assert.assertEquals(String.format(formattedMessage, start, joiner).trim(), expected);
        }
    }
}
