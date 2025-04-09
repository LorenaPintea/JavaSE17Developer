package module_8.lesson27_databases;

import java.sql.*;

public class NullHandling {
    public static void showAll(Statement statement, String query) {
        try {
            ResultSet result = statement.executeQuery(query);
            var resultSetMetaData = result.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            String[] columnNames = new String[columnCount];

            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = resultSetMetaData.getColumnName(i + 1);
            }

            while (result.next()) {
                StringBuilder stringBuilder = new StringBuilder();

                for (String column : columnNames) {
                    stringBuilder.append(column).append(": ").append(result.getString(column)).append(", ");
                }

                stringBuilder.setLength(stringBuilder.length() - 2);

                System.out.println(stringBuilder);
            }
        } catch (SQLException exception) {
            System.out.println("SQL statement incorrect!");
        }

    }

    public static void main(String[] args) throws Throwable {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:simpledb;");
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE drinks SET drink = ?, cash = ? WHERE id = ?")) {
            showAll(statement, "SELECT * FROM drinks");

            preparedStatement.setString(1, "Coffee");
            preparedStatement.setInt(2, 30);
            preparedStatement.setInt(3, 1);

            int rowCount = preparedStatement.executeUpdate();
            System.out.println("Update changed " + rowCount + " rows.");
            showAll(statement, "SELECT * FROM drinks");

            //Parameters remain for reuse unless overwritten or "clearParameter()" SO BE CAREFUL!
            preparedStatement.setNull(2, Types.INTEGER);
            preparedStatement.setInt(3,2);

            rowCount = preparedStatement.executeUpdate();
            System.out.println("Update changed " + rowCount + " rows.");
            showAll(statement, "SELECT * FROM drinks");
        }
    }
}
