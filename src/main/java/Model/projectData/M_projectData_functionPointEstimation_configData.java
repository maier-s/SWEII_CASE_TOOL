package Model.projectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="M_projectData_functionPointEstimation_configData")
@XmlAccessorType(XmlAccessType.FIELD)

public class M_projectData_functionPointEstimation_configData {

    public M_projectData_functionPointEstimation_configData() {}

    @XmlTransient
    //variables for factors
    public int factorEntanglement = 0;
    public int factorDecentralization = 0;
    public int factorTransactionrate = 0;

    public int factorProcessingCalculation = 0;
    public int factorProcessingControl = 0;
    public int factorProcessingException = 0;
    public int factorProcessingLogic = 0;

    public int factorReusability = 0;
    public int factorConversion = 0;
    public int factorCustomizability = 0;

    public int e2Sum = 0;

    /**
     * sets one factor to the provided value
     *
     * @param factorNo which factor to change
     * @param value    what value to set it to
     */
    public void setFactor(int factorNo, int value) {
        switch (factorNo) {
            case 1:
                factorEntanglement = value;
                break;
            case 2:
                factorDecentralization = value;
                break;
            case 3:
                factorTransactionrate = value;
                break;
            case 41:
                factorProcessingCalculation = value;
                break;
            case 42:
                factorProcessingControl = value;
                break;
            case 43:
                factorProcessingException = value;
                break;
            case 44:
                factorProcessingLogic = value;
                break;
            case 5:
                factorReusability = value;
                break;
            case 6:
                factorConversion = value;
                break;
            case 7:
                factorCustomizability = value;
                break;
            default:
                // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * gets the value of the factor
     *
     * @param factorNo which factor to get
     */
    public int getFactor(int factorNo) {
        switch (factorNo) {
            case 1:
                return factorEntanglement;
            case 2:
                return factorDecentralization;
            case 3:
                return factorTransactionrate;
            case 41:
                return factorProcessingCalculation;
            case 42:
                return factorProcessingControl;
            case 43:
                return factorProcessingException;
            case 44:
                return factorProcessingLogic;
            case 5:
                return factorReusability;
            case 6:
                return factorConversion;
            case 7:
                return factorCustomizability;
            default:
                return 0;
            // TODO: evtl. besser try catch -> prüfen und wenn besser implementieren
        }
    }

    /**
     * method adds all factors and therefore calculates the total sum of all factors E2
     */
    public void calcFactorSumE2() {
        e2Sum = factorEntanglement
                + factorDecentralization
                + factorTransactionrate
                + factorProcessingCalculation
                + factorProcessingControl
                + factorProcessingException
                + factorProcessingLogic
                + factorReusability
                + factorConversion
                + factorCustomizability;
    }
}
