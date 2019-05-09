package project.web.controller.usercontroller.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.database.dao.ProductDAO;
import project.web.controller.AbstractController;
import project.database.dto.data.ProductData;
import project.web.controller.ActionMethod;

@Controller
public class ProductController extends AbstractController<ProductData> {

    private ProductData productData;

    @ActionMethod
    private void buy(){
        System.out.println("ADDING: " + productData.getName());
    }

    @Override
    protected void modify() {}

    @Override
    protected void delete() {}

    @Override
    protected void create() {}

    @Override
    protected void get(Long id) {
        this.productData = ProductDAO.getInstance().getItem(id);
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }
}
