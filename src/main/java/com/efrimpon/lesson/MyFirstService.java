package com.efrimpon.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:customer.properties"),
        @PropertySource("classpath:customer-2.properties")
})
public class MyFirstService {

    //Inject a bean
    //Field injection
//    @Autowired
//    @Qualifier("mySecondClass") //using the method name
    private FirstClass myFirstClass;

    //Reading system properties
    private Environment environment;



    //Reading custom property
    @Value("${my.prop}")
    private String customPropFromAnotherFile;

    public String getCustomPropFromAnotherFile() {
        return customPropFromAnotherFile;
    }

    @Value("${my.prop.2}")
    private String customPropFromAnotherFile2;

    public String getCustomPropFromAnotherFile2() {
        return customPropFromAnotherFile2;
    }

    @Value("${my.prop.double}")
    private String customPropFromAnotherFile3;

    public Double getCustomPropFromAnotherFile3() {
        return Double.parseDouble(customPropFromAnotherFile3);
    }



    //Constructor injection
//    public MyFirstService(
//          FirstClass myFirstClass
//    ) {
//        this.myFirstClass = myFirstClass;
//    }

    //Method injection
//    @Autowired
//    public void injectDependencies(
//            FirstClass firstClass
//    ) {
//        this.myFirstClass = firstClass;
//    }

    //setter injection
    @Autowired
    public void setMyFirstClass( @Qualifier("bean1") FirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }
    public String getOperatingSystem(){
        return environment.getProperty("os.name");
    }
    public String readProperty(){
        return environment.getProperty("my.customer.property");
    }



    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }
}
