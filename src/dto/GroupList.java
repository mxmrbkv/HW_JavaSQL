package dto;

public class GroupList {

    private int id;
    private String nameGroup;
    private int idCurator;

    public GroupList(int id, String nameGroup, int idCurator) {

        this.id = id;
        this.nameGroup = nameGroup;
        this.idCurator = idCurator;
    }

    public int getId() {
        return this.id;
    }

    public String getNameGroup() {
        return this.nameGroup;
    }

    public int getIdCurator() {
        return this.idCurator;
    }
}


