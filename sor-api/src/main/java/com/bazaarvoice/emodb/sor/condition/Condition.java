package com.bazaarvoice.emodb.sor.condition;

import com.bazaarvoice.emodb.sor.condition.deser.ConditionDeserializer;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.annotation.Nullable;
import java.io.IOException;

/**
 * A boolean test applied against a JSON object.
 * <p>
 * Use {@link Conditions} to create {@code Condition} objects.
 */
@JsonDeserialize(using = ConditionDeserializer.class)
public interface Condition {

    <T, V> V visit(ConditionVisitor<T, V> visitor, @Nullable T context);

    @JsonValue
    String toString();

    void appendTo(Appendable buf) throws IOException;

    boolean equals(@Nullable Object o);

    int hashCode();
}
