package project.database.dto;

public abstract class AbstractData {

    public abstract Long getId();

    public String getDataDetailAddress() {
        String name = this.getClass().getSimpleName();
        return "get" + name.substring(0,name.indexOf("Data")) + "/" + getId();
    }
}
