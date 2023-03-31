public class OMSTypeAAA {

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public String getPortfolioCode() {
        return PortfolioCode;
    }

    public void setPortfolioCode(String portfolioCode) {
        PortfolioCode = portfolioCode;
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

    public String ISIN;
    public String PortfolioCode;
    public Double Nominal;

    @Override
    public String toString() {
        return ISIN + "," + PortfolioCode + "," + Nominal + "," + TransactionType ;
    }

    public String TransactionType;

}
