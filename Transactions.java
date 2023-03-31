import com.opencsv.bean.CsvBindByName;

public class Transactions {
    private static final long serialVersionUID = 1L;

    public String getSecurityId() {
        return SecurityId;
    }

    public void setSecurityId(String securityId) {
        SecurityId = securityId;
    }

    @CsvBindByName
    public String SecurityId;

    public String getPortfolioId() {
        return PortfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        PortfolioId = portfolioId;
    }

    @CsvBindByName
    public String PortfolioId;

    public Double getNominal() {
        return Nominal;
    }

    public void setNominal(Double nominal) {
        Nominal = nominal;
    }

    @CsvBindByName
    public Double Nominal;

    public String getOMS() {
        return OMS;
    }

    public void setOMS(String OMS) {
        this.OMS = OMS;
    }

    @CsvBindByName
    public String OMS;

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    @CsvBindByName
    public String TransactionType;

    @Override
    public String toString() {
        return "Transactions{" +
                "SecurityId='" + SecurityId + '\'' +
                ", PortfolioId='" + PortfolioId + '\'' +
                ", Nominal='" + Nominal + '\'' +
                ", OMS='" + OMS + '\'' +
                ", TransactionType='" + TransactionType + '\'' +
                '}';
    }
}
