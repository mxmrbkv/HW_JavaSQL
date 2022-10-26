package tables;

import dto.StudList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student extends AbsTable {
    public Student() throws SQLException {
        super("Student");

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
        students.add(new StudList(15, "Yarigina Yana Maksimovna", "Woman", 7689));
        }
    private List<StudList> students = new ArrayList<>();

    public void insertData() throws SQLException {

        for(StudList student: students) {
            iDbExecutor.execute(String.format("insert into Student values ('%d','%s', '%s', '%d');", student.getId(),
                    student.getFio(), student.getSex(), student.getIdGroup()), false);
        }
    }

    public void dataPrintln() throws SQLException {

        ResultSet students = iDbExecutor.execute("select * from Student", true);
        while(students.next()) {
            System.out.println(String.format("id = %d fio = %s sex = %s idGroup = %d", students.getInt(1),
                    students.getString(2), students.getString(3), students.getInt(4)));

            // ����� ���� ������� -  SELECT * FROM student WHERE sex = 'woman';
            // ����� ��� id -  SELECT * FROM student WHERE id;

        }
    }
}