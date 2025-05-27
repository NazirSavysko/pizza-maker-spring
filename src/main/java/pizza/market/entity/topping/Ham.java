package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("ham")
@Scope(SCOPE_PROTOTYPE)
public final class Ham implements Topping {
    private final String name;

    public Ham() {
        this.name = "Ham";
    }

    @Override
    public String getName() {
        return name;
    }
}
