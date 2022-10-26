package dto;

public class CuratorList {

    private int id;
    private  String fio;

    public CuratorList(int id, String fio) {

        this.id = id;
        this.fio = fio;
    }

    public int getId() {
        return this.id;
    }

    public String getFio() {
        return this.fio;
    }
}
