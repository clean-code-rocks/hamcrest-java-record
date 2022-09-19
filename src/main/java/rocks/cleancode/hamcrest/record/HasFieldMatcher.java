package rocks.cleancode.hamcrest.record;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;
import java.util.Optional;

import static java.util.Arrays.stream;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Matches a record field.
 *
 * @param <R> Record type
 * @param <T> Field type
 * @since 1.0.0
 */
public class HasFieldMatcher<R extends Record, T> extends TypeSafeDiagnosingMatcher<R> {

    /**
     * Create a matcher for not null field.
     *
     * @param fieldName Field name
     * @return Not null field matcher
     * @param <R> Record type
     * @since 1.0.0
     */
    public static <R extends Record> Matcher<R> hasField(String fieldName) {
        return new HasFieldMatcher<>(fieldName, is(notNullValue()));
    }

    /**
     * Create a matcher for field value.
     *
     * @param fieldName Field name
     * @param valueMatcher Value matcher
     * @return Value matcher for field record
     * @param <R> Record type
     * @param <T> Value type
     * @since 1.0.0
     */
    public static <R extends Record, T> Matcher<R> field(String fieldName, Matcher<T> valueMatcher) {
        return new HasFieldMatcher<>(fieldName, valueMatcher);
    }

    private final String fieldName;
    private final Matcher<T> valueMatcher;

    private HasFieldMatcher(String fieldName, Matcher<T> valueMatcher) {
        this.fieldName = fieldName;
        this.valueMatcher = valueMatcher;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean matchesSafely(R record, Description mismatchDescription) {
        Optional<RecordComponent> recordComponent = recordComponent(record);

        if (recordComponent.isEmpty()) {
            mismatchDescription.appendText("was not found");

            return false;
        }

        Object value = invoke(recordComponent.get(), record);

        valueMatcher.describeMismatch(value, mismatchDescription);

        return valueMatcher.matches(value);
    }

    private Optional<RecordComponent> recordComponent(R record) {
        RecordComponent[] recordComponents = record.getClass().getRecordComponents();

        return stream(recordComponents)
                .filter(rc -> rc.getName().equals(fieldName))
                .findFirst();
    }

    private Object invoke(RecordComponent recordComponent, R record) {
        try {
            return recordComponent.getAccessor().invoke(record);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void describeTo(Description description) {
        description
                .appendText("field '")
                .appendText(fieldName)
                .appendText("' ");

        valueMatcher.describeTo(description);
    }

}
