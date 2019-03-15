package dao.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
