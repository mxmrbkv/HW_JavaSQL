package tables;

import dto.GroupList;
import dto.StudList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Group extends AbsTable {
    public Group() {
        super("group1");

        group.add(new GroupList(6689, "One group", 23));
        group.add(new GroupList(6690, "Two group", 24));
        group.add(new GroupList(7689, "Three group", 25));
    }

    private List<GroupList> group = new ArrayList<>();

    public void insertData() throws SQLException {

        for (GroupList group: group) {
            iDbExecutor.execute(String.format("insert into group1 values (%d, '%s', %d);", group.getId(),
                    group.getNameGroup(), group.getIdCurator()), false);
        }
    }

    public void dataPrintln() throws SQLException {

        ResultSet group = iDbExecutor.execute("select * from group1", true);
        while(group.next()) {
            System.out.println(String.format("id = %d nameGroup = %s idCurator = %d", group.getInt(1),
                    group.getString(2), group.getInt(3)));
        }

        }
}

