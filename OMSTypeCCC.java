public class OMSTypeCCC {
    public String getPortfolioCode() {
        return PortfolioCode;
    }

    public void setPortfolioCode(String portfolioCode) {
        PortfolioCode = portfolioCode;
    }

    public String getTicker() {
        return Ticker;
    }

    public void setTicker(String ticker) {
        Ticker = ticker;
    }

    public Double getNominal() {
        return Nominal;
    }

    public void setNominal(Double nominal) {
        Nominal = nominal;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String PortfolioCode;
    public String Ticker;
    public Double Nominal;
    public String TransactionType;

    public String toString() {
        return Ticker + "," + PortfolioCode + "," + Nominal + "," + TransactionType ;
    }
}
