package pizza.market.entity.dough;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("yeastDough")
@Scope(SCOPE_PROTOTYPE)
public final class YeastDough implements Dough {
    private final String name;

    public YeastDough() {
        this.name = "Yeast Dough";
    }

    @Override
    public String getName() {
        return name;
    }
}
