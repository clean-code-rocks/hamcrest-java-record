package rocks.cleancode.hamcrest.record;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class HasPropertyMatcherTest {

    record Person(String firstName, String lastName) {}

    @Test
    public void should_matcher_non_null_property() {
        Person person = new Person("John", "DOE");

        assertThat(person, new HasPropertyMatcher<>("firstName"));
    }

}
