package pizza.market.entity.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pizza.market.entity.dough.Dough;
import pizza.market.entity.topping.Topping;

import static java.lang.System.out;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("italianPizza")
@Scope(SCOPE_PROTOTYPE)
public final class ItalianPizza implements Pizza {
    private final Dough yeastDough;
    private final Topping peperoni;
    private final Topping olives;
    private final Topping mushrooms;

    @Autowired
    public ItalianPizza(
            @Qualifier("yeastDough") final Dough yeastDough,
            @Qualifier("pepperoni")   final Topping peperoni,
            @Qualifier("olives")     final Topping olives,
            @Qualifier("mushroom")   final Topping mushrooms
    ){
        this.yeastDough = yeastDough;
        this.peperoni = peperoni;
        this.olives = olives;
        this.mushrooms = mushrooms;
    }

    @Override
    public void bake() {
        out.println("Baking Italian pizza...");
        out.printf("Dough: %s%n",yeastDough.getName());
        out.printf("Topping: %s, %s, %s%n", peperoni.getName(), olives.getName(), mushrooms.getName());
    }
}
