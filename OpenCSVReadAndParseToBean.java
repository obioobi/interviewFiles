import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OpenCSVReadAndParseToBean {
    public static final String AAA = "AAA";
    public static final String BBB = "BBB";
    public static final String CCC = "CCC";

    private static final String TRANSACTIONS_CSV_FILE_PATH = "C:\\Temp\\transactions.csv";
    private static final String SECURITIES_CSV_FILE_PATH = "C:\\Temp\\securities.csv";
    private static final String PORTFOLIOS_CSV_FILE_PATH = "C:\\Temp\\portfolios.csv";

    private static final String AAA_CSV_FILE_PATH = "C:\\Temp\\omsTypeAAA.csv";
    private static final String BBB_CSV_FILE_PATH = "C:\\Temp\\omsTypeBBB.csv";
    private static final String CCC_CSV_FILE_PATH = "C:\\Temp\\omsTypeCCC.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader transactionFileReader = Files.newBufferedReader(Paths.get(TRANSACTIONS_CSV_FILE_PATH));
                Reader securitiesFileReader = Files.newBufferedReader(Paths.get(SECURITIES_CSV_FILE_PATH));
                Reader portfoliosFileReader = Files.newBufferedReader(Paths.get(PORTFOLIOS_CSV_FILE_PATH));
        ) {
            CsvToBean csvToBeanTransactions = new CsvToBeanBuilder(transactionFileReader)
                    .withType(Transactions.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            CsvToBean csvToBeanSecurities = new CsvToBeanBuilder(securitiesFileReader)
                    .withType(Securities.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            CsvToBean csvToBeanPortfolios = new CsvToBeanBuilder(portfoliosFileReader)
                    .withType(Portfolios.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Securities> securitiesList = csvToBeanSecurities.parse();
            List<Portfolios> portfoliosList = csvToBeanPortfolios.parse();

            Map<String, String> portfolioMap = portfoliosList.stream().collect(Collectors.toMap(Portfolios -> ((String) Portfolios.getPortfolioId()), Portfolios -> (String) Portfolios.PortfolioCode));

            Map<String, String> securitiesCusipMap = securitiesList.stream().collect(Collectors.toMap(Securities -> ((String) Securities.getSecurityId()), Securities -> (String) Securities.getCUSIP()));
            Map<String, String> securitiesISINMap = securitiesList.stream().collect(Collectors.toMap(Securities -> ((String) Securities.getSecurityId()), Securities -> (String) Securities.getISIN()));
            Map<String, String> securitiesTickerMap = securitiesList.stream().collect(Collectors.toMap(Securities -> ((String) Securities.getSecurityId()), Securities -> (String) Securities.getTicker()));

            Iterator<Transactions> transactionsIterator = csvToBeanTransactions.iterator();

            while (transactionsIterator.hasNext()) {
                Transactions transactions = transactionsIterator.next();
                if (transactions.getOMS().equals(AAA)) {
                    writeOMSTypeAAA(securitiesISINMap, portfolioMap, transactions);
                }
                if (transactions.getOMS().equals(BBB)) {
                    OMSTypeBBB omsTypeBBB= new OMSTypeBBB();
                    writeOMSTypeBBB(securitiesCusipMap, portfolioMap, transactions);
                }
                if (transactions.getOMS().equals(CCC)) {
                    writeOMSTypeCCC(securitiesTickerMap, portfolioMap, transactions);
                }
            }
        }
    }

    private static void writeOMSTypeCCC(Map<String, String> securitiesTickerMap, Map<String, String> portfolioMap, Transactions transactions) throws IOException {
        OMSTypeCCC omsTypeCCC = new OMSTypeCCC();
        omsTypeCCC.setTicker(securitiesTickerMap.get(transactions.getSecurityId()));
        omsTypeCCC.setPortfolioCode(portfolioMap.get(transactions.getPortfolioId()));
        omsTypeCCC.setNominal(transactions.getNominal());
        omsTypeCCC.setTransactionType(transactions.getTransactionType());
        String cccFilePath = CCC_CSV_FILE_PATH;
        CSVWriter writer = new CSVWriter(new FileWriter(cccFilePath));
        String [] record = omsTypeCCC.toString().split(",");
        writer.writeNext(record);
        writer.close();
    }

    private static void writeOMSTypeBBB(Map<String, String> securitiesCusipMap, Map<String, String> portfolioMap, Transactions transactions) throws IOException {
        OMSTypeBBB omsTypeBBB = new OMSTypeBBB();
        omsTypeBBB.setCusip(securitiesCusipMap.get(transactions.getSecurityId()));
        omsTypeBBB.setPortfolioCode(portfolioMap.get(transactions.getPortfolioId()));
        omsTypeBBB.setNominal(transactions.getNominal());
        omsTypeBBB.setTransactionType(transactions.getTransactionType());
        String bbbFilePath = BBB_CSV_FILE_PATH;
        CSVWriter writer = new CSVWriter(new FileWriter(bbbFilePath));
        String [] record = omsTypeBBB.toString().split(",");
        writer.writeNext(record);
        writer.close();
    }

    private static void writeOMSTypeAAA(Map<String, String> securitiesISINMap, Map<String, String> portfolioMap, Transactions transactions) throws IOException {
        OMSTypeAAA omsTypeAAA= new OMSTypeAAA();
        omsTypeAAA.setISIN(securitiesISINMap.get(transactions.getSecurityId()));
        omsTypeAAA.setPortfolioCode(portfolioMap.get(transactions.getPortfolioId()));
          omsTypeAAA.setNominal(transactions.getNominal());
        omsTypeAAA.setTransactionType(transactions.getTransactionType());
        String aaaFilePath = AAA_CSV_FILE_PATH;
        CSVWriter writer = new CSVWriter(new FileWriter(aaaFilePath));
        String [] record = omsTypeAAA.toString().split(",");
        writer.writeNext(record);
        writer.close();
    }
}