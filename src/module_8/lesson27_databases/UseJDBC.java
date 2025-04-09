package module_8.lesson27_databases;

import java.sql.*;
import java.util.Arrays;

public class UseJDBC {
    public static void main(String[] args) throws Throwable {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:derby:simpledb;create=true;" );
             Statement statement = connection.createStatement()) {
            try {
                statement.execute("drop table drinks");
                System.out.println("Table 'drinks' existed, deleted now!");
            } catch (SQLException sqlException) {
                System.out.println("Table 'drinks' didn't exist!");
            }

            boolean createResponse = statement.execute(
                    "create table drinks (" +
                            "id INTEGER PRIMARY KEY GENERATED ALWAYS " +
                            "AS IDENTITY(Start with 1, Increment by 1), " +
                            "name varchar(12) not null, drink varchar(20), " +
                            "cash int, currency char(1))");

            System.out.println("Execute create table returns " + createResponse);

            boolean insertResponse = statement.execute(
                    "insert into drinks(name, drink, cash, currency) " +
                            "values('Fred', 'Coffee', 50, '$')");

            System.out.println("Execute insert returns " + insertResponse);

            int insertRowCount = statement.getUpdateCount();
            System.out.println("Insert modified " + insertRowCount + " rows.");

            statement.executeUpdate(
                    "insert into drinks(name, drink, cash, currency) " +
                            "values('Lorena', 'Tea', 20, '$')");
            statement.executeUpdate(
                    "insert into drinks(name, drink, cash, currency) " +
                            "values('Jim', 'Pepsi Max', 30, '$')");

            statement.addBatch(
                    "insert into drinks(name, drink, cash, currency) " +
                            "values('Sheila', 'Water', 10, '$')");
            statement.addBatch(
                    "insert into drinks(name, drink, cash, currency) " +
                            "values('Joe', 'Wine', 100, '$')");

            int[] batchResult = statement.executeBatch();
            System.out.println("Batch results are " + Arrays.toString(batchResult));

            ResultSet result = statement.executeQuery("select * from drinks");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String drink = result.getString("drink");
                String cash = result.getString("cash");
                String currency = result.getString("currency");

                System.out.printf("%3d: %12s, likes %s%s\n", id, name, drink,
                        (cash == null ? "" : ", and is carrying " + currency + cash));
            }
        }
    }
}
