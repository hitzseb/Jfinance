package org.jfinance.chart.model;

public class Meta {
    private String currency;
    private String symbol;
    private String fullExchangeName;
    private String instrumentType;
    private String exchangeTimezoneName;
    private double regularMarketPrice;
    private double regularMarketDayHigh;
    private double regularMarketDayLow;
    private long regularMarketVolume;

    public Meta() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public void setFullExchangeName(String fullExchangeName) {
        this.fullExchangeName = fullExchangeName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public void setRegularMarketDayHigh(double regularMarketDayHigh) {
        this.regularMarketDayHigh = regularMarketDayHigh;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public void setRegularMarketDayLow(double regularMarketDayLow) {
        this.regularMarketDayLow = regularMarketDayLow;
    }

    public long getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public void setRegularMarketVolume(long regularMarketVolume) {
        this.regularMarketVolume = regularMarketVolume;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "currency='" + currency + '\'' +
                ", symbol='" + symbol + '\'' +
                ", fullExchangeName='" + fullExchangeName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", exchangeTimezoneName='" + exchangeTimezoneName + '\'' +
                ", regularMarketPrice=" + regularMarketPrice +
                ", regularMarketDayHigh=" + regularMarketDayHigh +
                ", regularMarketDayLow=" + regularMarketDayLow +
                ", regularMarketVolume=" + regularMarketVolume +
                '}';
    }
}
