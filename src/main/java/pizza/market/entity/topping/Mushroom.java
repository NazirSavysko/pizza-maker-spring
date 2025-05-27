package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("mushroom")
@Scope(SCOPE_PROTOTYPE)
public final class Mushroom implements Topping {
    private final String name;

    public Mushroom() {
        this.name = "Mushroom";
    }

    @Override
    public String getName() {
        return name;
    }
}
