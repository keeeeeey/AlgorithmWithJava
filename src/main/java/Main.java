public class Main {
    public static int splitAndSum(String text) {
        if (isEmpty(text)) return 0;

        return getSum(toInts(text.split("-")));
    }

    public static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    public static int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static boolean isEmpty(String text) {
        if (text == null) return true;
        return text.isEmpty();
    }

    public static void main(String[] args) {

        int ret = splitAndSum("11-22-33");

        System.out.println(ret);

    }
}