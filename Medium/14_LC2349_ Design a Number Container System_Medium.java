
import java.util.*;

class NumberContainers {

    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> set = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {

        if (map.containsKey(index)) {
            int old = map.get(index);
            set.get(old).remove(index);
        }

        map.put(index, number);

        set.putIfAbsent(number, new TreeSet<>());
        set.get(number).add(index);
    }

    public int find(int number) {

        if (!set.containsKey(number) || set.get(number).isEmpty()) {
            return -1;
        }

        return set.get(number).first();
    }
}
