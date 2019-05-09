package project.database.dao;

import project.database.AbstractDAO;
import project.database.dto.data.ProductData;

import java.util.*;

public class ProductDAO extends AbstractDAO<ProductData> {

    private static ProductDAO dao = new ProductDAO();

    private ProductDAO(){}

    public static ProductDAO getInstance(){
        return dao;
    }


    //TODO remove

    private static Map<Long,ProductData> products;

    static{
        products = new HashMap<>();
        products.put(1L,new ProductData(1L,"jablko", (double) 1,1));
        products.put(2L,new ProductData(2L,"banan", (double) 2,2));
        products.put(3L,new ProductData(3L,"gruszka", (double) 3,3));
        products.put(4L,new ProductData(4L,"sliwka", (double) 4,4));
    }

    @Override
    public List<ProductData> getItems() {
        List<ProductData> l = new ArrayList<>(products.values());
        return l;
    }

    @Override
    public ProductData getItem(Long id) {
        return products.get(id);
    }
}
