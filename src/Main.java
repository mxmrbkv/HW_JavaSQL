import db.IDbExecutor;
import db.MySqlIDbExecutor;
import tables.AbsTable;
import tables.Curator;
import tables.Group;
import tables.Student;

import java.sql.SQLException;

public class Main {

    public static void main(String... args) throws SQLException {

        IDbExecutor iDbExecutor = new MySqlIDbExecutor();

        // Создание таблицы студентов

        AbsTable student = new Student();
            student.delete();
            student.create();
            student.insertData();
            student.dataPrintln();

        // Создание  таблицы группы

        AbsTable group = new Group();
            group.delete();
            group.create();
            group.insertData();
            group.dataPrintln();

        // Создание таблицы куратор

        AbsTable curator = new Curator();
            curator.delete();
            curator.create();
            curator.insertData();
            curator.dataPrintln();
            }
    }



