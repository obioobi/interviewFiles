import com.opencsv.bean.CsvBindByName;

public class Portfolios {
    public String getPortfolioId() {
        return PortfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        PortfolioId = portfolioId;
    }

    @Override
    public String toString() {
        return "Portfolios{" +
                "PortfolioId='" + PortfolioId + '\'' +
                ", PortfolioCode='" + PortfolioCode + '\'' +
                '}';
    }

    public String getPortfolioCode() {
        return PortfolioCode;
    }

    public void setPortfolioCode(String portfolioCode) {
        PortfolioCode = portfolioCode;
    }

    @CsvBindByName
    public String PortfolioId;

    @CsvBindByName
    public String PortfolioCode;
}
