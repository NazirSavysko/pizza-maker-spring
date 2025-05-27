package pizza.market.entity.factory;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pizza.market.entity.pizza.AmericanPizza;
import pizza.market.entity.pizza.Pizza;
import pizza.market.entity.pizza.AsianPizza;
import pizza.market.entity.pizza.ItalianPizza;
import pizza.market.entity.topping.*;

public final class PizzaFactory {
    private static final String CONFIGURATION_PACKAGE_FOR_DOUGH = "pizza.market.entity.dough";
    private static final String CONFIGURATION_PACKAGE_FOR_PIZZA = "pizza.market.entity.pizza";
    private static final String CONFIGURATION_PACKAGE_FOR_TOPPING = "pizza.market.entity.topping";

    private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(
                    CONFIGURATION_PACKAGE_FOR_DOUGH,
                    CONFIGURATION_PACKAGE_FOR_PIZZA,
                    CONFIGURATION_PACKAGE_FOR_TOPPING
            );


    private PizzaFactory(){
    }

    public static Pizza createPizza(final String type) {
        switch (type) {
            case "American pizza":
                return context.getBean("americanPizza", AmericanPizza.class);
            case "Asian pizza":
                return  context.getBean("asianPizza", AsianPizza.class);
            case "Italian pizza":
                return context.getBean("italianPizza", ItalianPizza.class);
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }

    public static void closeFactory() {
        if (context instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext)context).close();
        }else{
            throw new IllegalStateException("Context is not an instance of AnnotationConfigApplicationContext");
        }
    }
}
