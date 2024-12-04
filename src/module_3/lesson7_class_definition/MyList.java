package module_3.lesson7_class_definition;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MyList<E> implements Iterable<E>{
    private E[] data = (E[]) (new Object[10]);
    private int count = 0;

    public void add (E element) {
        data[count++] = element;
    }

    private class MyIterator implements Iterator<E> {
        private int progress = 0;

        @Override
        public boolean hasNext() {
            return progress < count;
        }

        @Override
        public E next() {
            return data[progress++];
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString() {
        return Arrays.stream(data)
                .limit(count)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "My List[", "]"));
    }
}

class TryMyList {
    public static void main(String[] args) {
        MyList<String> stringMyList = new MyList<>();
        MyList<Integer> integerMyList = new MyList<>();

        stringMyList.add("Hello");
        stringMyList.add("Bom dia");
        stringMyList.add("Buna ziua");
        stringMyList.add("Buenos dias");

        integerMyList.add(0);
        integerMyList.add(1);
        integerMyList.add(8);
        integerMyList.add(9);

        System.out.println(stringMyList);
        System.out.println(integerMyList);
        System.out.println("------------------------------------------------");

        Iterator<String> iterator1 = stringMyList.iterator();
        Iterator<String> iterator2 = stringMyList.iterator();

        Iterator<Integer> iterator3 = integerMyList.iterator();

        System.out.println("iterator 1 " + iterator1.next());
        System.out.println("iterator 1 " + iterator1.next());
        System.out.println("iterator 3 " + iterator3.next());
        System.out.println("iterator 2 " + iterator2.next());
        System.out.println("iterator 2 " + iterator2.next());
        System.out.println("iterator 1 " + iterator1.next());
        System.out.println("iterator 3 " + iterator3.next());
        System.out.println("iterator 2 " + iterator2.next());
        System.out.println("iterator 3 " + iterator3.next());

    }
}
