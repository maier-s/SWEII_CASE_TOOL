package MODEL;


import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

//TODO: KONTROLLFLUSSGRAPH
// This class imports an Object/Project from an XML file
public class M_IMPORT {
    /**
     * this class imports a Project from an XML file
     */
    private M_PROJECTDATA projData;
    private M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData;

    public M_IMPORT() {
        projData = new M_PROJECTDATA();
        confData = M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.getConfigData();
    }

    // code idea from: https://howtodoinjava.com/jaxb/unmarshal-without-xmlrootelement/
    public M_PROJECTDATA importProject(String path) {
        /**
         * This function imports a project by converting an XML file to the projectData Java Object
         * @param path the path for the project that has to be imported
         * @return projectData returns the loaded project in a M_PROJECTDATA object
         */
        File xmlFile = new File(path);
        if (!xmlFile.exists()) {
            throw new RuntimeException("File does not exist");
        }
        else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_PROJECTDATA.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_PROJECTDATA> jaxbElement = (JAXBElement<M_PROJECTDATA>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_PROJECTDATA.class);

                M_PROJECTDATA projectData_temp = jaxbElement.getValue();
                projData = projectData_temp;
                System.out.println(projectData_temp);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return projData;
    }

    public void importProject(M_PROJECTDATA projData, String path) {
        /**
         * This function imports a project by converting an XML file to the projectData Java Object
         * @param path the path for the project that has to be imported
         * @return projectData returns the loaded project in a M_PROJECTDATA object
         */

        File xmlFile = new File(path);
        if (!xmlFile.exists() && projData != null) {
            throw new RuntimeException("Parameter failure");
        }
        else {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                JAXBElement<M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA> jaxbElement = (JAXBElement<M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA>) jaxbUnmarshaller
                        .unmarshal(new StreamSource(xmlFile), M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.class);

                M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_temp = jaxbElement.getValue();
                confData = confData_temp;
                System.out.println(confData);
                projData.setM_projectData_functionPointEstimation_configData(confData); //TODO: check if relevant für Tests? (in fPEstimation muss eine Referenz auf die configData gehalten werden, sonst werden die Berechnungen zu kompliziert) sh. ProjectData Funktion
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}