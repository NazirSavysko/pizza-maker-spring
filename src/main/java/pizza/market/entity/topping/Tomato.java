package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("tomato")
@Scope(SCOPE_PROTOTYPE)
public final class Tomato  implements Topping {
    private final String name;

    public Tomato() {
        this.name = "Tomato";
    }

    @Override
    public String getName() {
        return name;
    }
}
