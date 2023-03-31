public class OMSTypeBBB {
    public String getCusip() {
        return Cusip;
    }

    public void setCusip(String cusip) {
        Cusip = cusip;
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

    public String Cusip;
    public String PortfolioCode;
    public Double Nominal;
    public String TransactionType;

    public String toString() {
        return Cusip + "," + PortfolioCode + "," + Nominal + "," + TransactionType ;
    }
}
