package pizza.market.entity.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pizza.market.entity.dough.Dough;
import pizza.market.entity.topping.Topping;

import static java.lang.System.out;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("asianPizza")
@Scope(SCOPE_PROTOTYPE)
public final class AsianPizza implements Pizza {
    private final Dough shortcrustDough;
    private final Topping ham;
    private final Topping cucumbers;
    private final Topping olives;
    private final Topping mushrooms;

    @Autowired
    public AsianPizza(
            @Qualifier("shortcrustDough") final Dough shortcrustDough,
            @Qualifier("ham")             final Topping ham,
            @Qualifier("cucumber")        final Topping cucumbers,
            @Qualifier("olives")          final Topping olives,
            @Qualifier("mushroom")        final Topping mushrooms
    ){
        this.shortcrustDough = shortcrustDough;
        this.ham = ham;
        this.cucumbers = cucumbers;
        this.olives = olives;
        this.mushrooms = mushrooms;
    }

    @Override
    public void bake() {
        out.println("Baking Asian pizza...");
        out.printf("Dough: %s%n",shortcrustDough.getName());
        out.printf("Topping: %s, %s, %s, %s%n",ham.getName(),cucumbers.getName(),olives,mushrooms.getName());
    }
}
