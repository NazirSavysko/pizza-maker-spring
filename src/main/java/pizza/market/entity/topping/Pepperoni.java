package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("pepperoni")
@Scope(SCOPE_PROTOTYPE)
public final class Pepperoni implements Topping {
    private final String name;

    public Pepperoni() {
        this.name = "Pepperoni";
    }

    @Override
    public String getName() {
        return name;
    }
}
