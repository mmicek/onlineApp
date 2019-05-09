package project.database;

import project.database.dto.AbstractData;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDAO<T extends AbstractData> {

    public T getItem(Long id){
        return EntityManager.getInstance().getItem(id,getDataClass());
    }

    public List<T> getItems() { return EntityManager.getInstance().getItems(); }

    @SuppressWarnings("unchecked")
    Class<T> getDataClass(){
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
