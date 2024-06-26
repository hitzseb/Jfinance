package org.jfinance.chart.model;

public class Meta {
    private String currency;
    private String symbol;
    private String exchangeName;
    private String fullExchangeName;
    private String instrumentType;
    private String timezone;
    private String exchangeTimezoneName;
    private double regularMarketPrice;
    private double fiftyTwoWeekHigh;
    private double fiftyTwoWeekLow;
    private double regularMarketDayHigh;
    private double regularMarketDayLow;
    private long regularMarketVolume;

    public Meta() {
    }

    public Meta(String currency, String symbol, String exchangeName, String fullExchangeName, String instrumentType, String timezone, String exchangeTimezoneName, double regularMarketPrice, double fiftyTwoWeekHigh, double fiftyTwoWeekLow, double regularMarketDayHigh, double regularMarketDayLow, long regularMarketVolume) {
        this.currency = currency;
        this.symbol = symbol;
        this.exchangeName = exchangeName;
        this.fullExchangeName = fullExchangeName;
        this.instrumentType = instrumentType;
        this.timezone = timezone;
        this.exchangeTimezoneName = exchangeTimezoneName;
        this.regularMarketPrice = regularMarketPrice;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
        this.regularMarketDayHigh = regularMarketDayHigh;
        this.regularMarketDayLow = regularMarketDayLow;
        this.regularMarketVolume = regularMarketVolume;
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

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
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
                ", exchangeName='" + exchangeName + '\'' +
                ", fullExchangeName='" + fullExchangeName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", timezone='" + timezone + '\'' +
                ", exchangeTimezoneName='" + exchangeTimezoneName + '\'' +
                ", regularMarketPrice=" + regularMarketPrice +
                ", fiftyTwoWeekHigh=" + fiftyTwoWeekHigh +
                ", fiftyTwoWeekLow=" + fiftyTwoWeekLow +
                ", regularMarketDayHigh=" + regularMarketDayHigh +
                ", regularMarketDayLow=" + regularMarketDayLow +
                ", regularMarketVolume=" + regularMarketVolume +
                '}';
    }
}
