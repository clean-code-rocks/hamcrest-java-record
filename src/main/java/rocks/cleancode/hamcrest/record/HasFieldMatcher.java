package rocks.cleancode.hamcrest.record;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;
import java.util.Optional;

import static java.util.Arrays.stream;

public class HasFieldMatcher<R extends Record> extends TypeSafeDiagnosingMatcher<R> {

    public static <R extends Record> Matcher<R> hasField(String fieldName) {
        return new HasFieldMatcher<>(fieldName);
    }

    private final String fieldName;

    private HasFieldMatcher(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    protected boolean matchesSafely(R record, Description mismatchDescription) {
        Optional<RecordComponent> recordComponent = recordComponent(record);

        if (recordComponent.isEmpty()) {
            mismatchDescription.appendText("was not found");

            return false;
        }

        mismatchDescription.appendText("was null");

        return recordComponent
                .map(rc -> invoke(rc, record))
                .isPresent();
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

    @Override
    public void describeTo(Description description) {
        description
                .appendText("field '")
                .appendText(fieldName)
                .appendText("' is not null");
    }

}
