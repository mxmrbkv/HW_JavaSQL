package tables;

import db.IDbExecutor;
import db.MySqlIDbExecutor;
import tables.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbsTable implements ITable {

    private String tableName;
    protected IDbExecutor iDbExecutor;

    public  IDbExecutor getDbExecutor() {
        return  iDbExecutor;
    }

    public AbsTable(String tableName) {
        this.tableName = tableName;
        iDbExecutor = new MySqlIDbExecutor();
    }

    @Override
    public void delete() throws SQLException {
        iDbExecutor.execute(String.format("drop table if exists %s", tableName), false);
    }

    protected String createPredicate(String[] predicateValues) {
        return String.format("where %s", String.join(" and ", predicateValues));
    }
    public abstract void insertData () throws SQLException;
    public abstract void dataPrintln() throws SQLException;
}
