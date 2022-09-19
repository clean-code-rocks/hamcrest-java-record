package rocks.cleancode.hamcrest.record;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HasFieldMatcher<R extends Record> extends TypeSafeDiagnosingMatcher<R> {

    public HasFieldMatcher(String fieldName) {
    }

    @Override
    protected boolean matchesSafely(R item, Description mismatchDescription) {
        return true;
    }

    @Override
    public void describeTo(Description description) {

    }

}
