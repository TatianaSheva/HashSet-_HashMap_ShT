import java.util.*;

public class Main {

    static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] arg) {

        String[] textAsArray = text.toLowerCase(Locale.ROOT).split("");

        //Map для хранения "Символа-Количество раз встретился"
        Map<String, Integer> words = new HashMap<>();

        for (String text : textAsArray) {
            if (Objects.equals(text, "") || check(text)) {
                continue;
            }
            if (words.containsKey(text)) {
                int i = words.get(text);
                i++;
                words.put(text, ++i);
                continue;
            }
            words.put(text, 1);
        }
        System.out.println(words);


        Collection<Integer> values = words.values();

        int max = getMax(values);
        int min = getMin(values);

        List<String> maxInjects = new ArrayList<>();
        List<String> minInjects = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == max) {
                maxInjects.add(entry.getKey());
            } else if (entry.getValue() == min) {
                minInjects.add(entry.getKey());
            }
        }

        System.out.println("Максимальное количество: " + maxInjects);
        System.out.println("Минимальное количество: " + minInjects);

    }

    private static boolean check(String text) {
        char[] ch = text.toCharArray();
        return !Character.isLetter(ch[0]);
    }


    private static int getMin(Collection<Integer> values) {
        List<Integer> integers = new ArrayList<>(values);
        int min = integers.get(0);
        for (Integer number : integers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }


    private static int getMax(Collection<Integer> values) {
        List<Integer> integers = new ArrayList<>(values);
        int max = integers.get(0);
        for (Integer number : integers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}