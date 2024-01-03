package in.ashokit.generator;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {

		String prefix = "TCS";
		String suffix = "";

		String sql = "select emp_id_seq.nextVal from dual";
		try (ResultSet rst = session.getJdbcConnectionAccess().obtainConnection().createStatement().executeQuery(sql)) {

			if (rst.next()) {
				int int1 = rst.getInt(1);

				suffix = String.valueOf(int1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prefix + suffix;
	}

}
