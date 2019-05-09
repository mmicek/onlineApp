package project.database;

import project.database.dto.AbstractData;
import project.database.dto.data.ProductData;

import java.util.LinkedList;
import java.util.List;

public class EntityManager {

    private static EntityManager entityManager = new EntityManager();

    public static EntityManager getInstance(){
        return entityManager;
    }

    private EntityManager(){
        //TODO
    }

    public <T> T getItem(Long id,Class<T> clazz){
        return (T) new ProductData("banan",10.0,10);
    }

    public <T extends AbstractData> List<T> getItems() {
        LinkedList<ProductData> items = new LinkedList<>();
        items.add(getItem(1L, ProductData.class));
        items.add(getItem(1L, ProductData.class));
        return (List<T>) items;
    }

    public <T> void createItem(T data) {
        System.out.println("creating: " + data.getClass());
    }

    public <T> void deleteItem(Long id, Class<T> dataClass) {
    }

    public <T> void modifyItem(T data) {
    }

}
