package rocks.cleancode.hamcrest.record;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HasPropertyMatcher<R extends Record> extends TypeSafeDiagnosingMatcher<R> {

    public HasPropertyMatcher(String fieldName) {
    }

    @Override
    protected boolean matchesSafely(R item, Description mismatchDescription) {
        return true;
    }

    @Override
    public void describeTo(Description description) {

    }

}
