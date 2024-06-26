package org.jfinance.chart.model;

import java.util.List;

public class Indicators {
    private List<Quote> quote;
    private List<AdjClose> adjclose;

    public Indicators() {
    }

    public Indicators(List<Quote> quote, List<AdjClose> adjclose) {
        this.quote = quote;
        this.adjclose = adjclose;
    }

    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    public List<AdjClose> getAdjclose() {
        return adjclose;
    }

    public void setAdjclose(List<AdjClose> adjclose) {
        this.adjclose = adjclose;
    }

    @Override
    public String toString() {
        return "Indicators{" +
                "quote=" + quote +
                ", adjclose=" + adjclose +
                '}';
    }
}
