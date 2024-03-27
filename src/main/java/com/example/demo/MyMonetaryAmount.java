package com.example.demo;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.Objects;

import javax.money.CurrencyUnit;
import javax.money.MonetaryContext;
import javax.money.MonetaryOperator;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;

public class MyMonetaryAmount extends Number implements Comparable<MyMonetaryAmount> {

    private static final long serialVersionUID = 1L;
    private static final String CURRENCY_CODE = "INR";

    private BigDecimal amount;
    private javax.money.MonetaryAmount monetaryAmount;

    public MyMonetaryAmount(BigDecimal amount) {
        super();
        Objects.requireNonNull(amount, "amount is required.");
        // do rounding because sometimes we divide an amount by a number, and therefore can get >2 decimals
        this.amount = amount.setScale(2, HALF_UP);
        this.monetaryAmount = Money.of(this.amount, MyMonetaryAmount.CURRENCY_CODE);
//        log.debug("created MonetaryAmount {} from {}", this, amount);
    }

    public static MyMonetaryAmount money(BigDecimal amount) {
        return new MyMonetaryAmount(amount);
    }
    
    public static MyMonetaryAmount of(BigDecimal amount) {
        return new MyMonetaryAmount(amount);
    }
    
    public static MyMonetaryAmount money(Integer amount) {
        return new MyMonetaryAmount(new BigDecimal(amount));
    }
    
    public static MyMonetaryAmount of(Integer amount) {
        return new MyMonetaryAmount(new BigDecimal(amount));
    }
    
    private static MyMonetaryAmount money(javax.money.MonetaryAmount mon) {
        Objects.requireNonNull(mon, "amount is required.");
        BigDecimal amt = mon.getNumber().numberValue(BigDecimal.class);
        MyMonetaryAmount ma = new MyMonetaryAmount(amt);
        return ma;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public javax.money.MonetaryAmount getMonetaryAmount() {
        return monetaryAmount;
    }

    @Override
    public String toString() {
        return amount.toPlainString();
    }

    @Override
    public boolean equals(Object obj) {
        MyMonetaryAmount other = (MyMonetaryAmount) obj;
        return other != null && amount.compareTo(other.getAmount()) == 0;
    }
    
    @Override
    public int hashCode() {
        return amount.intValue();
    }
    
    public boolean isMultipleOf100() {
        boolean result = false;
        int intValue = amount.intValue();
        BigDecimal rupees = new BigDecimal(intValue);
        if (rupees.compareTo(amount) == 0 // i.e. 0 paise
                && intValue % 100 == 0) {
            result = true;
        }
        return result;
    }
    
//    @Override
    public MyMonetaryAmount with(MonetaryOperator operator){
        return money(operator.apply(this.monetaryAmount));
    }
    
//    @Override
    public boolean isNegative(){
        return signum() < 0;
    }

//    @Override
    public boolean isNegativeOrZero(){
        return signum() <= 0;
    }

//    @Override
    public boolean isPositive(){
        return signum() > 0;
    }

//    @Override
    public boolean isPositiveOrZero(){
        return signum() >= 0;
    }

//    @Override
    public boolean isZero(){
        return signum() == 0;
    }

//    @Override
    public CurrencyUnit getCurrency() {
        return monetaryAmount.getCurrency();
    }

//    @Override
    public NumberValue getNumber() {
        return monetaryAmount.getNumber();
    }

    @Override
    public int compareTo(MyMonetaryAmount o) {
        return monetaryAmount.compareTo(o.getMonetaryAmount());
    }

//    @Override
    public MonetaryContext getContext() {
        return monetaryAmount.getContext();
    }

//    @Override
//    public MonetaryAmountFactory<? extends MonetaryAmount> getFactory() {
//        return monetaryAmount.getFactory();
//    }

//    @Override
    public boolean isGreaterThan(MyMonetaryAmount amount) {
        return monetaryAmount.isGreaterThan(amount.getMonetaryAmount());
    }

//    @Override
    public boolean isGreaterThanOrEqualTo(MyMonetaryAmount amount) {
        return monetaryAmount.isGreaterThanOrEqualTo(amount.getMonetaryAmount());
    }

//    @Override
    public boolean isLessThan(MyMonetaryAmount amount) {
        return monetaryAmount.isLessThan(amount.getMonetaryAmount());
    }

//    @Override
    public boolean isLessThanOrEqualTo(MyMonetaryAmount amt) {
        return monetaryAmount.isLessThanOrEqualTo(amt.getMonetaryAmount());
    }

//    @Override
    public boolean isEqualTo(MyMonetaryAmount amount) {
        return monetaryAmount.isEqualTo(amount.getMonetaryAmount());
    }

//    @Override
    public int signum() {
        return monetaryAmount.signum();
    }

//    @Override
    public MyMonetaryAmount add(MyMonetaryAmount augend) {
        return money(monetaryAmount.add(augend.getMonetaryAmount()));
    }

//    @Override
    public MyMonetaryAmount subtract(MyMonetaryAmount subtrahend) {
        return money(monetaryAmount.subtract(subtrahend.getMonetaryAmount()));
    }

//    @Override
    public MyMonetaryAmount multiply(long multiplicand) {
        return money(monetaryAmount.multiply(multiplicand));
    }

//    @Override
    public MyMonetaryAmount multiply(double multiplicand) {
        return money(monetaryAmount.multiply(multiplicand));
    }

//    @Override
    public MyMonetaryAmount multiply(Number multiplicand) {
        return money(monetaryAmount.multiply(multiplicand));
    }

//    @Override
    public MyMonetaryAmount divide(long divisor) {
        return money(monetaryAmount.divide(divisor));
    }

//    @Override
    public MyMonetaryAmount divide(double divisor) {
        return money(monetaryAmount.divide(divisor));
    }

//    @Override
    public MyMonetaryAmount divide(Number divisor) {
        return money(monetaryAmount.divide(divisor));
    }

//    @Override
    public MyMonetaryAmount remainder(long divisor) {
        return money(monetaryAmount.remainder(divisor));
    }

//    @Override
    public MyMonetaryAmount remainder(double divisor) {
        return money(monetaryAmount.remainder(divisor));
    }

//    @Override
    public MyMonetaryAmount remainder(Number divisor) {
        return money(monetaryAmount.remainder(divisor));
    }

//    @Override
    public MyMonetaryAmount[] divideAndRemainder(long divisor) {
        javax.money.MonetaryAmount[] divideAndRemainder = monetaryAmount.divideAndRemainder(divisor);
        return new MyMonetaryAmount[] {money(divideAndRemainder[0]), money(divideAndRemainder[1])};
    }

//    @Override
    public MyMonetaryAmount[] divideAndRemainder(double divisor) {
        javax.money.MonetaryAmount[] divideAndRemainder = monetaryAmount.divideAndRemainder(divisor);
        return new MyMonetaryAmount[] {money(divideAndRemainder[0]), money(divideAndRemainder[1])};
    }

//    @Override
    public MyMonetaryAmount[] divideAndRemainder(Number divisor) {
        javax.money.MonetaryAmount[] divideAndRemainder = monetaryAmount.divideAndRemainder(divisor);
        return new MyMonetaryAmount[] {money(divideAndRemainder[0]), money(divideAndRemainder[1])};
    }

//    @Override
    public MyMonetaryAmount divideToIntegralValue(long divisor) {
        return money(monetaryAmount.divideToIntegralValue(divisor));
    }

//    @Override
    public MyMonetaryAmount divideToIntegralValue(double divisor) {
        return money(monetaryAmount.divideToIntegralValue(divisor));
    }

//    @Override
    public MyMonetaryAmount divideToIntegralValue(Number divisor) {
        return money(monetaryAmount.divideToIntegralValue(divisor));
    }

//    @Override
    public MyMonetaryAmount scaleByPowerOfTen(int power) {
        return money(monetaryAmount.scaleByPowerOfTen(power));
    }

//    @Override
    public MyMonetaryAmount abs() {
        return money(monetaryAmount.abs());
    }

//    @Override
    public MyMonetaryAmount negate() {
        return money(monetaryAmount.negate());
    }

//    @Override
    public MyMonetaryAmount plus() {
        return money(monetaryAmount.plus());
    }

//    @Override
    public MyMonetaryAmount stripTrailingZeros() {
        return money(monetaryAmount.stripTrailingZeros());
    }

    @Override
    public int intValue() {
        return amount.intValue();
    }

    @Override
    public long longValue() {
        return amount.longValue();
    }

    @Override
    public float floatValue() {
        return amount.floatValue();
    }

    @Override
    public double doubleValue() {
        return amount.doubleValue();
    }


}
