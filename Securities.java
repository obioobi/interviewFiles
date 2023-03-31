
import com.opencsv.bean.CsvBindByName;

public class Securities {


    public String getSecurityId() {
        return SecurityId;
    }

    public void setSecurityId(String securityId) {
        SecurityId = securityId;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public String getTicker() {
        return Ticker;
    }

    public void setTicker(String ticker) {
        Ticker = ticker;
    }

    public String getCUSIP() {
        return CUSIP;
    }

    public void setCUSIP(String CUSIP) {
        this.CUSIP = CUSIP;
    }

    @CsvBindByName
    private String SecurityId;

    @CsvBindByName
    private String ISIN;

    @CsvBindByName
    private String Ticker;

    @CsvBindByName
    private String CUSIP;
}
