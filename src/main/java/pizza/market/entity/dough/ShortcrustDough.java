package pizza.market.entity.dough;
;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@Component("shortcrustDough")
@Scope(SCOPE_PROTOTYPE)
public final class ShortcrustDough implements Dough {
    private final String name;

    public ShortcrustDough() {
        this.name = "Shortcrust Pastry";
    }

    @Override
    public String getName() {
        return name;
    }
}
