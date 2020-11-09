package id;

import java.nio.file.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
public class MyResourceConfig extends ResourceConfig{

  public MyResourceConfig() {
	  System.out.println("config test");
  }
  


}
