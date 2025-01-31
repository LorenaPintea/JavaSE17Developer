package module_3.lesson12_inheritance;

sealed class Base /* permits Sub1, Sub2*/ {
}

final class Sub1 extends Base {
}

final class Sub2 extends Base {
}

public class OmitPermit {
}
