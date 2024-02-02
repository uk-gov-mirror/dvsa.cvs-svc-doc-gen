package uk.gov.dvsa.model.cvs.certificateData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TankStatement {

    @JsonProperty
    private String substancesPermitted;

    @JsonProperty
    private String statement;


    @JsonProperty
    private String productList;


    public TankStatement() {
    }

    public TankStatement(String substancesPermitted, String statement, String productList) {
        this.substancesPermitted = substancesPermitted;
        this.statement = statement;
        this.productList = productList;
    }

    public String getSubstancesPermitted() {
        return substancesPermitted;
    }

    public void setSubstancesPermitted(String substancesPermitted) {
        this.substancesPermitted = substancesPermitted;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }


    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }
}
