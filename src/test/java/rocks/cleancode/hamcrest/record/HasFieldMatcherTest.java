package rocks.cleancode.hamcrest.record;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rocks.cleancode.hamcrest.record.HasFieldMatcher.hasField;

public class HasFieldMatcherTest {

    record Person(String firstName, String lastName) {}

    @Test
    public void should_match_non_null_field() {
        Person person = new Person("John", "DOE");

        assertThat(person, hasField("firstName"));
    }

    @Test
    public void should_fail_when_field_does_not_exist() {
        Person person = new Person("John", "DOE");

        AssertionError assertionError = assertThrows(
                AssertionError.class,
                () -> assertThat(person, hasField("birthDate"))
        );

        String expectedMessage = String.format(
                "%n%s%n%s",
                "Expected: field 'birthDate' is not null",
                "     but: was not found"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

    @Test
    public void should_fail_when_field_is_null() {
        Person person = new Person(null, "DOE");

        AssertionError assertionError = assertThrows(
                AssertionError.class,
                () -> assertThat(person, hasField("firstName"))
        );

        String expectedMessage = String.format(
                "%n%s%n%s",
                "Expected: field 'firstName' is not null",
                "     but: was null"
        );

        assertThat(assertionError.getMessage(), is(equalTo(expectedMessage)));
    }

}
