package in.ashokit.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String sequenceName = "order_id_seq";
        // Check if the sequence exists
        try (Connection obtainConnection = session.getJdbcConnectionAccess().obtainConnection()) {
            String checkIfExistsSql = "SELECT * FROM custom_sequence WHERE sequence_name = ?";
            try (PreparedStatement checkStatement = obtainConnection.prepareStatement(checkIfExistsSql)) {
                checkStatement.setString(1, sequenceName);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Sequence name already exists, update the next_val
                        String updateSql = "UPDATE custom_sequence SET next_val = next_val + 1 WHERE sequence_name = ?";
                        try (PreparedStatement updateStatement = obtainConnection.prepareStatement(updateSql)) {
                            updateStatement.setString(1, sequenceName);
                            updateStatement.executeUpdate();
                        }
                    } else {
                        // Sequence name doesn't exist, insert a new record
                        String insertSql = "INSERT INTO custom_sequence (sequence_name, next_val) VALUES (?, 1)";
                        try (PreparedStatement insertStatement = obtainConnection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                            insertStatement.setString(1, sequenceName);
                            insertStatement.executeUpdate();
                        }
                    }
                }
            }

            // Retrieve the updated/inserted sequence value
            String selectSql = "SELECT next_val FROM custom_sequence WHERE sequence_name = ?";
            try (PreparedStatement selectStatement = obtainConnection.prepareStatement(selectSql)) {
                selectStatement.setString(1, sequenceName);
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    if (resultSet.next()) {
                        long nextVal = resultSet.getLong("next_val");
                        return "TCS" + String.format("%06d", nextVal);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging or handling the exception appropriately
        }

        return null;
    }
}
