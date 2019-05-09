package project.web.search;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSearchCriteria<T> {

    public List<T> filter(List<T> data){
        Field[] declaredFields = this.getClass().getDeclaredFields();
        List<Field> fields = new LinkedList<>();
        List<T> result = new LinkedList<>();
        try {
            for(Field field : declaredFields){
                field.setAccessible(true);
                if(field.isAnnotationPresent(SearchField.class) && field.get(this) != null)
                    fields.add(field);
            }
            if(fields.isEmpty())
                return data;
            for(T item : data){
                for(Field field : fields) {
                    Field f = item.getClass().getDeclaredField(field.getName());
                    f.setAccessible(true);
                    if(!f.get(item).equals(field.get(this))) {
                        break;
                    }
                result.add(item);
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
