package io.mikael.app;

import com.google.common.collect.ImmutableSet;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Set;

/**
 * Our @EmbeddedId Key needs a string representation for the GET URLs in Spring Data REST.
 */
public class GenericKeyConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return ImmutableSet.of(
                new ConvertiblePair(String.class, Key.class),
                new ConvertiblePair(Key.class, String.class),
                new ConvertiblePair(Long.class, Key.class),
                new ConvertiblePair(Key.class, Long.class));
    }
    @Override
    public Object convert(final Object source, final TypeDescriptor st, final TypeDescriptor tt) {
        if (st.getType() == String.class && tt.getType() == Key.class) {
            return new Key(Long.parseLong(source.toString()));
        } else if (st.getType() == Key.class && tt.getType() == String.class) {
            return ((Key)source).getId().toString();
        } else if (st.getType() == Long.class && tt.getType() == Key.class) {
            return new Key((Long)source);
        } else if (st.getType() == Key.class && tt.getType() == Long.class) {
            return ((Key) source).getId();
        }
        return null;
    }
}
