package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Wrestling {

    public static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person p) {
            return p.height - this.height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Person(height, weight));
        }

        arr.sort(Comparator.naturalOrder());
        int answer = 0;
        int minWeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (arr.get(i).weight > minWeight) {
                minWeight = arr.get(i).weight;
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
