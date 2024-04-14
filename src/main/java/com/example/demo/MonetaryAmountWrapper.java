package com.example.demo;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.money.MonetaryContext;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;

public class MonetaryAmountWrapper implements MonetaryAmount {

    private MonetaryAmount wrapped;

    public MonetaryAmountWrapper(BigDecimal bd) {
        wrapped = Money.of(bd, "INR");
    }
    
    @Override
    public boolean equals(Object obj) {
        MonetaryAmount other = (MonetaryAmount) obj;
        return this.wrapped.equals(other);
    }
    
    @Override
    public int hashCode() {
        return wrapped.hashCode();
    }
    
    @Override
    public String toString() {
        return wrapped.toString();
    }

    @Override
    public CurrencyUnit getCurrency() {
        return wrapped.getCurrency();
    }

    @Override
    public NumberValue getNumber() {
        return wrapped.getNumber();
    }

    @Override
    public int compareTo(MonetaryAmount o) {
        return 0;
    }

    @Override
    public MonetaryContext getContext() {
        return wrapped.getContext();
    }

    @Override
    public MonetaryAmountFactory<? extends MonetaryAmount> getFactory() {
        return wrapped.getFactory();
    }

    @Override
    public boolean isGreaterThan(MonetaryAmount amount) {
        return wrapped.isGreaterThan(amount);
    }

    @Override
    public boolean isGreaterThanOrEqualTo(MonetaryAmount amount) {
        return wrapped.isGreaterThanOrEqualTo(amount);
    }

    @Override
    public boolean isLessThan(MonetaryAmount amount) {
        return wrapped.isLessThan(amount);
    }

    @Override
    public boolean isLessThanOrEqualTo(MonetaryAmount amt) {
        return wrapped.isLessThanOrEqualTo(amt);
    }

    @Override
    public boolean isEqualTo(MonetaryAmount amount) {
        return wrapped.isEqualTo(amount);
    }

    @Override
    public int signum() {
        return wrapped.signum();
    }

    @Override
    public MonetaryAmount add(MonetaryAmount augend) {
        return wrapped.add(augend);
    }

    @Override
    public MonetaryAmount subtract(MonetaryAmount subtrahend) {
        return wrapped.subtract(subtrahend);
    }

    @Override
    public MonetaryAmount multiply(long multiplicand) {
        return wrapped.multiply(multiplicand);
    }

    @Override
    public MonetaryAmount multiply(double multiplicand) {
        return wrapped.multiply(multiplicand);
    }

    @Override
    public MonetaryAmount multiply(Number multiplicand) {
        return wrapped.multiply(multiplicand);
    }

    @Override
    public MonetaryAmount divide(long divisor) {
        return wrapped.divide(divisor);
    }

    @Override
    public MonetaryAmount divide(double divisor) {
        return wrapped.divide(divisor);
    }

    @Override
    public MonetaryAmount divide(Number divisor) {
        return wrapped.divide(divisor);
    }

    @Override
    public MonetaryAmount remainder(long divisor) {
        return wrapped.remainder(divisor);
    }

    @Override
    public MonetaryAmount remainder(double divisor) {
        return wrapped.remainder(divisor);
    }

    @Override
    public MonetaryAmount remainder(Number divisor) {
        return wrapped.remainder(divisor);
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(long divisor) {
        return wrapped.divideAndRemainder(divisor);
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(double divisor) {
        return wrapped.divideAndRemainder(divisor);
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(Number divisor) {
        return wrapped.divideAndRemainder(divisor);
    }

    @Override
    public MonetaryAmount divideToIntegralValue(long divisor) {
        return wrapped.divideToIntegralValue(divisor);
    }

    @Override
    public MonetaryAmount divideToIntegralValue(double divisor) {
        return wrapped.divideToIntegralValue(divisor);
    }

    @Override
    public MonetaryAmount divideToIntegralValue(Number divisor) {
        return wrapped.divideToIntegralValue(divisor);
    }

    @Override
    public MonetaryAmount scaleByPowerOfTen(int power) {
        return wrapped.scaleByPowerOfTen(power);
    }

    @Override
    public MonetaryAmount abs() {
        return wrapped.abs();
    }

    @Override
    public MonetaryAmount negate() {
        return wrapped.negate();
    }

    @Override
    public MonetaryAmount plus() {
        return wrapped.plus();
    }

    @Override
    public MonetaryAmount stripTrailingZeros() {
        return wrapped.stripTrailingZeros();
    }

}



