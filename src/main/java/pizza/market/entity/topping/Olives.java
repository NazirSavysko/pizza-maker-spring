package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("olives")
@Scope(SCOPE_PROTOTYPE)
public final class Olives implements Topping {
    private final String name;

    public Olives() {
        this.name = "Olives";
    }

    @Override
    public String getName() {
        return name;
    }
}
