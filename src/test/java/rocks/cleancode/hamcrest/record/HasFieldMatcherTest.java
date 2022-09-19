package rocks.cleancode.hamcrest.record;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class HasFieldMatcherTest {

    record Person(String firstName, String lastName) {}

    @Test
    public void should_match_non_null_field() {
        Person person = new Person("John", "DOE");

        assertThat(person, new HasFieldMatcher<>("firstName"));
    }

}
