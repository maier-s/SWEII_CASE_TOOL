package MODEL;
// helpful links: https://junit.org/junit5/docs/current/user-guide/

import MODEL.PROJECTDATA.M_PROJECTDATA;
import MODEL.PROJECTDATA.M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//TODO: JAXBException --> Kein Test weil wir davon ausgehen dass JAXB korrekt durchläuft
class M_EXPORT_TEST {
    // Equivalence classes:
    // 1. tests whether marshalling works with M_projectdata pointing to null
    // 2. empty filename or with blanks or null
    // 3. filename with special signs (&,|, ³,\, ...)

    // 1. Testcase:
    @Test
    void export_projectData_nullProjectTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA projData_test = null;
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path));
    }

    // 2. Testcase:
    @Test
    void export_projectData_emptyFilenameTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA projData_test = new M_PROJECTDATA();
        projData_test.getM_projectData_productUse().setContent("TestProductUse");

        //Class 1 --> string with blanks
        String path1 = " ";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path1));

        //Class 2 --> Empty String
        String path2 = "";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path2));

        //Class 3 --> null
        String path3 = null;
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(projData_test, path3));
    }


    //3. Testcase
    @Test
    void export_projectData_cleanRun() {
        try {
            M_EXPORT export_test = new M_EXPORT();
            M_PROJECTDATA projData_test = new M_PROJECTDATA();
            projData_test.getM_projectData_productUse().setContent("TestProductUse");
            String path = "test.xml";
            export_test.export(projData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    // 4. Testcase:
    @Test
    void export_configData_nullProjectDataTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = null;
        String path = "test_export.xml";
        //Tests whether an error has occured by transforming from java into xml
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path));
    }

    // 5. Testcase:
    @Test
    void export_configData_emptyFilenameTest() {
        M_EXPORT export_test = new M_EXPORT();
        M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.getConfigData();

        //Class 1 --> string with blanks
        String path1 = " ";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path1));

        //Class 2 --> Empty String
        String path2 = "";
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path2));

        //Class 3 --> null
        String path3 = null;
        //Tests whether the file at location path can be found
        assertThrows(RuntimeException.class, () -> export_test.export(confData_test, path3));
    }


    // 6. Testcase
    @Test
    void export_configData_cleanRun() {
        try {
            M_EXPORT export_test = new M_EXPORT();
            M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA confData_test = M_PROJECTDATA_FUNCTIONPOINTESTIMATION_CONFIGDATA.getConfigData();
            String path = "test_config.xml";
            export_test.export(confData_test, path);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}