package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("bacon")
@Scope(SCOPE_PROTOTYPE)
public final class Bacon implements Topping {
    private final String name;

    public Bacon() {
        this.name = "Bacon";
    }

    @Override
    public String getName() {
        return name;
    }
}
