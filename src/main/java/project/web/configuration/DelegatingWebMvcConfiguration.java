package project.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import project.web.controller.AbstractController;
import project.web.controller.AbstractListController;
import project.web.controller.ActionMethod;

import java.lang.reflect.Method;
import java.util.*;

@Configuration
public class DelegatingWebMvcConfiguration extends org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration {

    /**
     Spring invokes method <code> getMappingForMethod </code> for every Controller twice.
     In first iteration this method will be invoked from class DelegatingWebMvcConfiguration
     (the class that i created and override method)
     The second one somehow Spring wants to call <code> WebMvcConfigurationSupport </code>
     and method <code> createRequestMappingHandlerMapping </code> and idk fucking why?

     So we need to override this method too
     */
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new RequestMappingHandler();
    }

    @Bean
    @Primary
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return super.requestMappingHandlerMapping();
    }


    @Configuration
    public static class RequestMappingHandler extends RequestMappingHandlerMapping {

        private static Set<ClassMethod> mappedClasses = new HashSet<>();
        private static String[] requestMappingMethods = {"getMethod","createMethod",
                "modifyMethod","deleteMethod","findMethod","actionMethod"};

        @Override
        protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
            if(AbstractController.class.isAssignableFrom(method.getDeclaringClass())
                    || AbstractListController.class.isAssignableFrom(method.getDeclaringClass())) {

                if(mappedClasses.contains(new ClassMethod(method,handlerType)))
                    return null;
                mappedClasses.add(new ClassMethod(method,handlerType));
                if (Arrays.asList(requestMappingMethods).contains(method.getName())) {
                    String url = getUrlPattern(method,handlerType);
                    return new RequestMappingInfo(url, new PatternsRequestCondition(url),
                            getMethodType(method.getName()), null, null,
                            null, null, null);
                }
                return null;

            }
            return super.getMappingForMethod(method,handlerType);
        }

        private String getUrlPattern(Method method, Class<?> handlerType) {
            String name = method.getName().substring(0,method.getName().indexOf("Method"))
                    + handlerType.getName().substring(handlerType.getName().lastIndexOf(".") + 1,
                    handlerType.getName().indexOf("Controller"));
            if(!(method.getName().equals("createMethod") || method.getName().equals("findMethod")))
                name +=  "/{id}";
            if(method.getName().equals("actionMethod"))
                name += "/{action}";
            return name;
        }

        private RequestMethodsRequestCondition getMethodType(String name) {
            switch(name){
                case "createMethod":
                    return new RequestMethodsRequestCondition(RequestMethod.POST);
                case "deleteMethod":
                    return new RequestMethodsRequestCondition(RequestMethod.DELETE);
                case "modifyMethod":
                    return new RequestMethodsRequestCondition(RequestMethod.PATCH);
                case "findMethod":
                    return new RequestMethodsRequestCondition(RequestMethod.POST,RequestMethod.GET);
                case "actionMethod":
                    return new RequestMethodsRequestCondition(RequestMethod.GET);
                default:
                    return new RequestMethodsRequestCondition(RequestMethod.GET);
            }
        }

        /**
         * Used to check if method on class was already mapped
         */
        private class ClassMethod{
            private Method method;
            private Class clazz;

            ClassMethod(Method method,Class clazz){
                this.method = method;
                this.clazz = clazz;
            }

            @Override
            public boolean equals(Object obj) {
                if(!(obj instanceof ClassMethod))
                    return false;
                ClassMethod m = (ClassMethod) obj;
                return m.clazz == this.clazz && m.method == this.method;
            }

            @Override
            public int hashCode() {
                return method.getName().length() + clazz.getName().length();
            }
        }
    }
}
