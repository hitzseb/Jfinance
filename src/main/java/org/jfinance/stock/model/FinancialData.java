package org.jfinance.stock.model;

public class FinancialData {
    /**
     * Represents earnings before interest, taxes, depreciation, and amortization.
     */
    private String ebitda;

    /**
     * Represents the cash on hand of the company.
     */
    private String cashOnHands;

    /**
     * Represents the total liabilities of the company.
     */
    private String totalLiabilities;

    /**
     * Represents the regular market price of the stock.
     */
    private String regularMarketPrice;

    /**
     * Represents the trailing annual dividend yield.
     */
    private String trailingAnnualDividendYield;

    /**
     * Represents the price-to-earnings ratio.
     */
    private String trailingPE;

    /**
     * Represents the market capitalization of the company.
     */
    private String marketCap;

    /**
     * Represents the book value per share.
     */
    private String bookValue;

    public FinancialData() {
    }

    public String getEbitda() {
        return ebitda;
    }

    public void setEbitda(String ebitda) {
        this.ebitda = ebitda;
    }

    public String getCashOnHands() {
        return cashOnHands;
    }

    public void setCashOnHands(String cashOnHands) {
        this.cashOnHands = cashOnHands;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public String getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(String regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public String getTrailingAnnualDividendYield() {
        return trailingAnnualDividendYield;
    }

    public void setTrailingAnnualDividendYield(String trailingAnnualDividendYield) {
        this.trailingAnnualDividendYield = trailingAnnualDividendYield;
    }

    public String getTrailingPE() {
        return trailingPE;
    }

    public void setTrailingPE(String trailingPE) {
        this.trailingPE = trailingPE;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getBookValue() {
        return bookValue;
    }

    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }

    @Override
    public String toString() {
        return "FinancialData{" +
                "ebitda='" + ebitda + '\'' +
                ", cashOnHands='" + cashOnHands + '\'' +
                ", totalLiabilities='" + totalLiabilities + '\'' +
                ", regularMarketPrice='" + regularMarketPrice + '\'' +
                ", trailingAnnualDividendYield='" + trailingAnnualDividendYield + '\'' +
                ", trailingPE='" + trailingPE + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", bookValue='" + bookValue + '\'' +
                '}';
    }
}
