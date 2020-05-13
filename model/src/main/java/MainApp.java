import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vivekco.Props;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("hello2");
        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("spring-jasypt.xml");

        EnvironmentStringPBEConfig s=(EnvironmentStringPBEConfig)

    applicationContext.getBean("environmentVariablesConfiguration");
        System.out.println(s.getAlgorithm());

        Props p=(Props)applicationContext.getBean(Props.class);
        System.out.println(p.getPassword());
    }
}

