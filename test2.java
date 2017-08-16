import java.io.Serializable;
import java.util.ArrayList;

public class test2 {
    // define basic interface for all objects
    interface ObjectWithID {
        public int getId();
    }

    public static class Teacher implements ObjectWithID {
        private final int id;

        public Teacher(final int id) {
            this.id = id;
        }

        @Override
        public int getId() {
            return this.id;
        }
    }

    public static class Student implements ObjectWithID {
        private final int id;

        public Student(final int id) {
            this.id = id;
        }

        @Override
        public int getId() {
            return this.id;
        }
    }

    // note T extends syntax
    public static class ListFromFile<T extends ObjectWithID> extends ArrayList<T> implements Serializable {
        public T getElement(final int id) {
            for (final T o : this)
                if (o.getId() == id)
                    return o;
            return null;
        }
    }

    public static void main(final String[] args) {
        final ListFromFile list = new ListFromFile<>();

        list.add(new Teacher(1));
        list.add(new Teacher(2));
        list.add(new Teacher(3));

        list.add(new Student(4));
        list.add(new Student(5));
        list.add(new Student(6));

        System.out.println(list.getElement(1)); // print teacher
        System.out.println(list.getElement(4)); // print student
    }
}
