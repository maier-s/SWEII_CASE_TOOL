package CONTROLLER.TAB;

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTCONTENTFACTORY;
import MODEL.PROJECTDATA.M_PROJECTDATA_PRODUCTDATA;
import VIEW.I_V_FRAME;

import javax.swing.*;

public class C_PRODUCTDATA implements I_C_PRODUCTDATA {
    private static C_PRODUCTDATA controllerProductData;
    private I_V_FRAME viewFrame;
    private M_PROJECTDATA projectData;

    private C_PRODUCTDATA() {
    }

    public static C_PRODUCTDATA getInstance(){
        if (controllerProductData == null) {
            controllerProductData = new C_PRODUCTDATA();
        }
        else{
            System.out.println("C_PRODUCTDATA Instance already created");
        }
        return controllerProductData;
    }

    @Override
    public void setLinks(I_V_FRAME view, M_PROJECTDATA projData) {
            viewFrame = view;
            projectData = projData;
    }

    private void setProductDataElements(M_PROJECTDATA_PRODUCTDATA projectDataProductData) {
        projectDataProductData.reference = viewFrame.getTextFieldproductDataReference().getText();
        projectDataProductData.memoryContent = viewFrame.getTextAreaproductDataDescription().getText();
        projectDataProductData.functionPointRET = (int) viewFrame.getSpinnerproductDataRET().getValue();
        projectDataProductData.functionPointDET = (int) viewFrame.getSpinnerproductDataDET().getValue();
        projectDataProductData.functionPointCategory = viewFrame.getComboBoxProdDataCategory().getSelectedItem().toString();
        projectDataProductData.calculateWeight();
    }

    @Override
    public void newProductContent() {
        System.out.println("Notified Tab Product Data that a new Element is requested");
        boolean alreadyexists = false;
        for (M_PROJECTDATA_PRODUCTDATA projectDataProductData : projectData.getProductDataList()) {
            if (projectDataProductData.id.equals(viewFrame.getTextFieldproductDataID().getText())) {
                alreadyexists = true;
                break;
            }
        }
        if (!alreadyexists) {
            if (!viewFrame.getTextFieldproductDataID().getText().isEmpty()) {
                //Using ProductContentFactory to create object
                M_PROJECTDATA_PRODUCTDATA newProductData = new M_PROJECTDATA_PRODUCTCONTENTFACTORY().createProductData(viewFrame.getTextFieldproductDataID().getText());
                setProductDataElements(newProductData);
                projectData.getProductDataList().add(newProductData);
                viewFrame.addProdDataIDListElement(viewFrame.getTextFieldproductDataID().getText());
                viewFrame.setWeightDescription(newProductData.functionPointWeighting);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Bitte ID eingeben um ein neues Produktdatum anzulegen",
                        "Achtung",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Produktdaten ID existiert bereits",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void notifySelectionChange(String selectedID) {
        M_PROJECTDATA_PRODUCTDATA selectedProjectData = null;
        for (M_PROJECTDATA_PRODUCTDATA projectDataproductData : projectData.getProductDataList()) {
            if (projectDataproductData.id.equals(selectedID)) {
                selectedProjectData = projectDataproductData;

            }
        }
        if (selectedProjectData == null) {
            JOptionPane.showMessageDialog(null,
                    "Keine ID selektiert um Aktualisierung durchzuführen",
                    "Achtung",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            viewFrame.updateProdDataInfo(selectedProjectData);
        }
        viewFrame.setWeightDescription(selectedProjectData.functionPointWeighting);
    }

    @Override
    public void deleteProductContent() {
        int index = 0;
        int removedElement = -1;
        for (M_PROJECTDATA_PRODUCTDATA projectDataproductData : projectData.getProductDataList()) {
            if (projectDataproductData.id.equals(viewFrame.getListproductDataID().getSelectedValue())) {
                removedElement = index;
            }
            index++;
        }
        if (removedElement >= 0) {
            projectData.getProductDataList().remove(removedElement);
            viewFrame.reinitializeProdDataIDList(projectData);
        }
    }

    @Override
    public void updateProjectData() {
        for (M_PROJECTDATA_PRODUCTDATA projectDataproductData : projectData.getProductDataList()) {
            if (projectDataproductData.id.equals(viewFrame.getListproductDataID().getSelectedValue())) {
                projectDataproductData.id = viewFrame.getTextFieldproductDataID().getText();
                setProductDataElements(projectDataproductData);
                viewFrame.changeProdDataIDListElement(projectDataproductData.id);
                viewFrame.setWeightDescription(projectDataproductData.functionPointWeighting);
            }
        }
    }

}