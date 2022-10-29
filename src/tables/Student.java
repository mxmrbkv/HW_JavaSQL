package tables;

import dto.StudList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student extends AbsTable {
    public Student() throws SQLException {
        super("student");

        students.add(new StudList(1, "Borzov Dmitry Alexseevich", "Man", 6689));
        students.add(new StudList(2, "Alimova Alisa Alexseevna", "Woman", 6689));
        students.add(new StudList(3, "Baranov Vadim Maksimovich", "Man", 6689));
        students.add(new StudList(4, "Gavrilova Irina Sergeevna", "Woman", 6689));
        students.add(new StudList(5, "Prihodko Milena Nikolaevna", "Woman", 7689));
        students.add(new StudList(6, "Kozjuhov Alex Andreevich", "Man", 7689));
        students.add(new StudList(7, "Odinochenko Michel Mechelovich", "Man", 6690));
        students.add(new StudList(8, "Rebikov Maksim Sergeevich", "Man", 6690));
        students.add(new StudList(9, "Stroev Dmitry Viktorovich", "Man", 7689));
        students.add(new StudList(10, "Smetanikova Ala Valeryevna", "Woman", 7689));
        students.add(new StudList(11, "Tokarev Maksim Maksimovich", "Man", 6690));
        students.add(new StudList(12, "Ulyanova Katrin Olegovna", "Woman", 6689));
        students.add(new StudList(13, "Ukznov Denis Vadimovich", "Man", 6689));
        students.add(new StudList(14, "Uvarov Artev Andreevich", "Man", 6690));
        students.add(new StudList(15, "Ivanoiva Inna Olegovna", "Woman", 7689));
        }
    private List<StudList> students = new ArrayList<>();

    public void create() throws SQLException {

        ResultSet tables = iDbExecutor.execute("show tables;", true);
        boolean isTableCreated = false;
        while (tables.next()) {
            if (tables.getString(1).equals("student")) {
                isTableCreated = true;
                break;
            }
        }

        //Создание таблицы студентов
        iDbExecutor.execute(String.format("create table %s (Id int, fio varchar(40), sex varchar(40), Id_group int);", "student"), false);
    }

    public void insertData() throws SQLException {

        for(StudList student: students) {
            iDbExecutor.execute(String.format("insert into student values ('%d','%s', '%s', '%d');", student.getId(),
                    student.getFio(), student.getSex(), student.getIdGroup()), false);
        }
    }

    public void dataPrintln() throws SQLException {

        ResultSet students = iDbExecutor.execute("SELECT * FROM student as s inner JOIN group_table as g on s.id_group = g.id;", true);
        while(students.next()) {
            System.out.println(String.format("id = %d fio = %s sex = %s idGroup = %d", students.getInt(1),
                    students.getString(2), students.getString(3), students.getInt(4)));

            // Вывести на экран информацию о всех студентах включая название группы и имя куратора -
            // SELECT * FROM student as s inner JOIN group_table as g on s.id_group = g.id INNER JOIN curator as c on g.id_curator = c.id;

            // Вывести на экран количество студентов - SELECT COUNT(*) FROM student;

            // Вывести студенток - SELECT * FROM student WHERE sex = 'woman';

            // Обновить данные по группе сменив куратора - UPDATE student SET id_group = 7689 WHERE id=1;

            // Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы) -
            // SELECT * FROM student WHERE id_Group = '6689';




        }
    }
}