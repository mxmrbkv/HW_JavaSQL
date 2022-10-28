package tables;

import dto.GroupList;
import dto.StudList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Group extends AbsTable {
    public Group() {
        super("group_table");

        group.add(new GroupList(6689, "One group", 23));
        group.add(new GroupList(6690, "Two group", 24));
        group.add(new GroupList(7689, "Three group", 25));
    }

    private List<GroupList> group = new ArrayList<>();

    public void create() throws SQLException {

        ResultSet tables = iDbExecutor.execute("show tables;", true);
        boolean isTableCreated = false;
        while (tables.next()) {
            if (tables.getString(1).equals("group_table")) {
                isTableCreated = true;
                break;
            }
        }

        iDbExecutor.execute(String.format("create table %s (Id int, name_Group varchar(40), Id_curator int);", "Group_table"), false);
    }

    public void insertData() throws SQLException {

        for (GroupList group: group) {
            iDbExecutor.execute(String.format("insert into group_table values (%d, '%s', %d);", group.getId(),
                    group.getNameGroup(), group.getIdCurator()), false);
        }
    }

    public void dataPrintln() throws SQLException {

        ResultSet group = iDbExecutor.execute("select * from group_table;", true);
        while(group.next()) {
            System.out.println(String.format("id = %d nameGroup = %s idCurator = %d", group.getInt(1),
                    group.getString(2), group.getInt(3)));
        }

        }
}

