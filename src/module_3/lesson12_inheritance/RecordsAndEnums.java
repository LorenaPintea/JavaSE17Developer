package module_3.lesson12_inheritance;

enum SubEnum implements BaseIF {
    ONE, TWO {
        @Override
        public String toString() {
            return super.toString() + " A subtype";
        }
    }
}

sealed interface BaseIF permits SubEnum, SubRecord {
}

record SubRecord() implements BaseIF {
}

public class RecordsAndEnums {
}
