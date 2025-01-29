package module_3.lesson12_inheritance;

sealed interface BaseIF permits SubEnum, SubRecord {}

enum SubEnum implements BaseIF {
    ONE, TWO {
        @Override
        public String toString() {
            return super.toString() + " A subtype";
        }
    };
}
record SubRecord() implements BaseIF {}

public class RecordsAndEnums {
}
