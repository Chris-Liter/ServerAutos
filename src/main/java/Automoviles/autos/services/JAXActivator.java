package Automoviles.autos.services;
/**
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
*/
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/*@OpenAPIDefinition(info = @Info(
        title = "Automóviles API",
        description = "API para gestionar automóviles", version = "1.0.0"))*/
@ApplicationPath("/rest")
public class JAXActivator extends Application{

}
