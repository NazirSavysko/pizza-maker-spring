package pizza.market.entity.topping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component("cucumber")
@Scope(SCOPE_PROTOTYPE)
public final class Cucumber implements Topping {
    private final String name;

    public Cucumber() {
        this.name = "Cucumber";
    }

    @Override
    public String getName() {
        return name;
    }
}
