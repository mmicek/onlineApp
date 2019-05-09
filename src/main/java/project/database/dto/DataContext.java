package project.database.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class DataContext {


}
