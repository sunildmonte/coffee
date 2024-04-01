package com.example.demo;

import java.math.BigDecimal;
import java.sql.Types;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractClassJavaType;
import org.hibernate.type.descriptor.jdbc.JdbcType;
import org.hibernate.type.descriptor.jdbc.JdbcTypeIndicators;

public class MyMoneyJavaType extends AbstractClassJavaType<MyMonetaryAmount> {

    private static final long serialVersionUID = 1L;

    public MyMoneyJavaType() {
        super(MyMonetaryAmount.class);
    }

    @Override
    public JdbcType getRecommendedJdbcType(JdbcTypeIndicators indicators) {
        return indicators.getTypeConfiguration()
                .getJdbcTypeRegistry()
                .getDescriptor(Types.NUMERIC);
    }
    
    @Override
    public String toString(MyMonetaryAmount value) {
        return value.toString();
    }
    
    @Override
    public MyMonetaryAmount fromString(CharSequence string) {
        return MyMonetaryAmount.of(new BigDecimal(string.toString()));
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <X> X unwrap(MyMonetaryAmount value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (MyMonetaryAmount.class.isAssignableFrom(type)) {
            return (X) value;
        }
        if (BigDecimal.class.isAssignableFrom(type)) {
            return (X) value.getAmount();
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);    
    }

    @Override
    public <X> MyMonetaryAmount wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (value instanceof CharSequence) {
            return fromString((CharSequence) value);
        }
        if (value instanceof BigDecimal) {
            return MyMonetaryAmount.of((BigDecimal) value);
        }
        if (value instanceof MyMonetaryAmount) {
            return (MyMonetaryAmount) value;
        }
        throw unknownWrap(value.getClass());
    }

}
