package baekjoonSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AgeSorting {

    public static StringTokenizer st;

    public static class Person implements Comparable<Person> {
        int age;
        String name;
        int idx;

        public Person(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        @Override
        public int compareTo(Person person) {
            if (this.age != person.age) {
                return this.age - person.age;
            } else {
                return this.idx - person.idx;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person person = new Person(age, name, i);
            list.add(person);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(list.get(i).age + " " + list.get(i).name + "\n");
        }

        System.out.println(sb);
    }
}
