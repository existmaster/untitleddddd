package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.ShopApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { ShopApplication.class })
public class CucumberSpingConfiguration {}
