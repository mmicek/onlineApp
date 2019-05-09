package project.web.search.criteria;

import project.database.dto.data.ProductData;
import project.web.search.AbstractSearchCriteria;
import project.web.search.SearchField;


public class ProductSearchCriteria extends AbstractSearchCriteria<ProductData> {

    @SearchField
    private Long id;

    @SearchField
    private String name;

    @SearchField
    private String type;

    @SearchField
    private String price;

    @SearchField
    private String quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
