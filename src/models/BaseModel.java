package models;

public abstract class BaseModel {
    private int id;

    public BaseModel(int id) {
        this.id = id;
    }

    protected BaseModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
