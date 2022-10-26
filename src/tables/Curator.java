package tables;

import dto.CuratorList;
import dto.GroupList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Curator extends AbsTable{

    public Curator(){
        super("Curator");

        curator.add(new CuratorList(1, "Jabovna Danna Artemovna"));
        curator.add(new CuratorList(2, "Tokunova Anna Victorovna"));
        curator.add(new CuratorList(3, "Uvarov Timofey Andreevich"));
    }

    private List<CuratorList> curator = new ArrayList<>();

    public void insertData() throws SQLException {

        for (CuratorList curator : curator) {
            iDbExecutor.execute(String.format("insert into Curator values ('%d', '%s');", curator.getId(), curator.getFio()), false);

        }
    }

    public void dataPrintln() throws SQLException {
        ResultSet curator = iDbExecutor.execute("select * from Curator", true);
        while(curator.next()) {
            System.out.println(String.format("id = %d fio = %s", curator.getInt(1), curator.getString(2)));
        }
    }
}
