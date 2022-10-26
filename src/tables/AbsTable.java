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
    public void create() throws SQLException {

        ResultSet tables = iDbExecutor.execute("show tables;", true);
        boolean isTableCreated = false;
        while (tables.next()) {
            if (tables.getString(1).equals(tableName)) {
                isTableCreated = true;
                break;
            }
        }

        //Создание таблицы студентов
//        iDbExecutor.execute(String.format("create table %s (Id int, fio varchar(40), Sex varchar(8), Id_group int);", tableName), false);

        ////Создание таблицы группы
        iDbExecutor.execute(String.format("create table %s (Id int, name_Group varchar(40), Id_curator int);", tableName), false);

        //Создание таблицы кураторов
//        iDbExecutor.execute(String.format("create table %s (Id int, fio varchar(20));", tableName), false);

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
