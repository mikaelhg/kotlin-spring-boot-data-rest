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
                new ConvertiblePair(Key.class, String.class));
    }
    @Override
    public Object convert(final Object source, final TypeDescriptor sourceType, final TypeDescriptor targetType) {
        if (sourceType.getType() == String.class && targetType.getType() == Key.class) {
            return new Key(Long.parseLong(source.toString()));
        } else if (sourceType.getType() == Key.class && targetType.getType() == String.class) {
            return ((Key)source).getId().toString();
        }
        return null;
    }
}
