package pizza.market;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static java.lang.String.format;
import static java.lang.System.setIn;
import static java.lang.System.setOut;
import static org.junit.jupiter.api.Assertions.*;


class PizzaMarketTest {

    private static final String MESSAGE_IF_THROW_EXCEPTION =
            "An error occurred while invoking the method: %s";
    private static Method method;

    @BeforeAll
    public static void setUp() throws NoSuchMethodException {
        method = PizzaMarket.class.getDeclaredMethod("makePizza");
        method.setAccessible(true);
    }


    @Test
    public void when_choose_american_pizza(){
        // Given
        final String input = "1\n";
        setIn(new ByteArrayInputStream(input.getBytes()));
        final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        setOut(new PrintStream(outputBuffer));

        try {
            // When
            method.invoke(null);

            // Then
            final String res = outputBuffer.toString();
            assertTrue(res.contains("Baking American pizza"));
        } catch (Exception e) {
            fail();
        }


    }

    @Test
    public void when_choose_italian_pizza(){
        // Given
        final String input = "2\n";
        setIn(new ByteArrayInputStream(input.getBytes()));
        final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        setOut(new PrintStream(outputBuffer));

        try {
            // When
            method.invoke(null);

            // Then
            final String res = outputBuffer.toString();
            assertTrue(res.contains("Baking Italian pizza"));
        } catch (Exception e) {
            fail(format(MESSAGE_IF_THROW_EXCEPTION,e.getMessage()));
        }

    }
    @Test
    public void when_choose_asian_pizza(){
        // Given
        final String input = "3\n";
        setIn(new ByteArrayInputStream(input.getBytes()));
        final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        setOut(new PrintStream(outputBuffer));


        try {
            // When
            method.invoke(null);

            //Then
            final String res = outputBuffer.toString();
            assertTrue(res.contains("Baking Asian pizza"));
        } catch (Exception e) {
            fail(format(MESSAGE_IF_THROW_EXCEPTION,e.getMessage()));
        }

    }

    @Test
    public void when_choose_invalid_number() {
        // Given
        final String input = "4\n";
        setIn(new ByteArrayInputStream(input.getBytes()));
        final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        setOut(new PrintStream(outputBuffer));

        // When
        try {
            method.invoke(null);
            final String res = outputBuffer.toString();
            assertTrue(res.contains("Invalid choice"));
        } catch (Exception e) {
            fail(format(MESSAGE_IF_THROW_EXCEPTION,e.getMessage()));
        }
    }
}