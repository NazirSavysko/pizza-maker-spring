package pizza.market.entity.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pizza.market.entity.dough.Dough;
import pizza.market.entity.topping.Topping;

import static java.lang.System.out;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("americanPizza")
@Scope(SCOPE_PROTOTYPE)
public final class AmericanPizza implements Pizza {
    private final Dough yeastDough;
    private final Topping cucumbers;
    private final Topping tomato;
    private final Topping bacon;

     @Autowired
    public AmericanPizza(
            @Qualifier("yeastDough") final Dough yeastDough,
            @Qualifier("cucumber")   final Topping cucumbers,
            @Qualifier("tomato")     final Topping tomato,
            @Qualifier("bacon")      final Topping bacon
     ){
        this.yeastDough = yeastDough;
        this.cucumbers = cucumbers;
        this.tomato = tomato;
        this.bacon = bacon;
    }


    @Override
    public void bake() {
        out.println("Baking American pizza...");
        out.printf("Dough: %s%n",yeastDough.getName());
        out.printf("Topping: %s, %s, %s%n",cucumbers.getName(),tomato.getName(),bacon.getName());
    }
}
