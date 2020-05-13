import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Test1 {
    public static void main(String[] args) throws Exception {

        RouteBuilder rb=new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:/Users/vivek/camelTest?noop=true").process(
                        new Processor() {
                            public void process(Exchange exchange) throws Exception {
                                String in=exchange.getIn().getBody(String.class);
                                System.out.println("Proc 1" + in);
                                exchange.getOut().setBody("Hello Removed");
                            }
                        }
                ).process(
                        new Processor() {
                            public void process(Exchange exchange) throws Exception {
                                String in=exchange.getIn().getBody(String.class);

                                System.out.println("Proc 2" + in);

                            }
                        }

                );
            }
        };
        CamelContext camelContext =new DefaultCamelContext();
        camelContext.addRoutes(rb);
        camelContext.start();

        Thread.sleep(100000);

        // stop the CamelContext
        camelContext.stop();
    }

}
