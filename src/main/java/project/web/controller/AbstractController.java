package project.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;


public abstract class AbstractController<T> {

    protected abstract void modify();
    protected abstract void delete();
    protected abstract void create();
    protected abstract void get(Long id);

    @RequestMapping(value = "{id}")
    private String getMethod(@PathVariable("id") Long id, Model model){
        get(id);
        model.addAttribute("item", this);
        return getJspFileName();
    }

    @RequestMapping
    private String createMethod(){
        create();
        return getJspFileName();
    }

    @RequestMapping
    private String modifyMethod(){
        modify();
        return getJspFileName();
    }

    @RequestMapping
    private String deleteMethod(@PathVariable("id") Long id){
        get(id);
        delete();
        return getJspFileName();
    }

    @RequestMapping(value = "/{id}/{action}")
    private Object actionMethod(
            @PathVariable("id") Long id,
            @PathVariable("action") String action,
            @RequestParam("forward") String forward){
        try{
            get(id);
            Method method = getClass().getDeclaredMethod(action);
            method.setAccessible(true);
            Object result = method.invoke(this);
            if(!method.getReturnType().equals(void.class))
                return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return "redirect:" + forward;
    }

    private String getJspFileName(){
        String className = this.getClass().getSimpleName();
        return className.substring(0,1).toLowerCase()
                + className.substring(1,className.indexOf("Controller"));
    }

}
