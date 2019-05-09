package project.web.controller.usercontroller.list;

import org.springframework.stereotype.Controller;
import project.database.dao.ProductDAO;
import project.database.dto.data.ProductData;
import project.web.controller.AbstractListController;
import project.web.search.criteria.ProductSearchCriteria;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductListController extends AbstractListController<ProductSearchCriteria> {

    private List<ProductData> productDataList;

    private List<String> types = Arrays.asList("data", "type1", "dupa");

    @Override
    protected void get() {
        productDataList = getSearchCriteria().filter(ProductDAO.getInstance().getItems());
    }

    public List<ProductData> getProductDataList() {
        return productDataList;
    }

    public void setProductDataList(List<ProductData> productDataList) {
        this.productDataList = productDataList;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
