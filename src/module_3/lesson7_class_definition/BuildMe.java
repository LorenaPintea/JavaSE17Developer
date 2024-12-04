package module_3.lesson7_class_definition;

import java.time.LocalDate;

public class BuildMe {
    private String name;
    private LocalDate date;

    private BuildMe() {};

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BuildMe template = new BuildMe();

        private Builder() {};

        public Builder name(String name) {
            template.name = name;
            return this;
        }

        public Builder date(LocalDate date) {
            template.date = date;
            return this;
        }

        public BuildMe build() {
            BuildMe result = template;
            template = null;
            return result;
        }
    }

    @Override
    public String toString() {
        return "BuildMe{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

class TryBuilder {
    public static void main(String[] args) {
        BuildMe buildMe = BuildMe.builder()
                .name("Lorena")
                .date(LocalDate.now())
                .build();

        System.out.println(buildMe);
    }
}
