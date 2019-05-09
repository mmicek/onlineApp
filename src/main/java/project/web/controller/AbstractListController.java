package project.web.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import project.web.search.AbstractSearchCriteria;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractListController<SC extends AbstractSearchCriteria>{

    protected abstract void get();

    private SC searchCriteria;

    @RequestMapping
    private String findMethod(SC searchCriteria, Model model) throws IllegalAccessException, InstantiationException {
        this.searchCriteria = searchCriteria;
        get();
        model.addAttribute("items",this);
        return getJspFileName();
    }

    private String getJspFileName(){
        String className = this.getClass().getSimpleName();
        return className.substring(0,1).toLowerCase()
                + className.substring(1,className.indexOf("Controller"));
    }

    public SC getSearchCriteria(){
        return searchCriteria;
    }

    public void setSearchCriteria(SC searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
