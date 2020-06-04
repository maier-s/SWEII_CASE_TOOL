package Controller;

import Controller.tab.I_C_tab;

/**
 * main CONTROLLER, that handles all programm functions not regarding special VIEWS.
 * Its only purpose is to create CONTROLLERS for the special VIEWS and handle USER-IO to "switch" between the different
 * views
 */
public interface I_C_frame{
    //TODO: create CONTROLLERS for each special VIEW
    //TODO: create the main frame of the programm V_frame

    //TODO: check if this can be deleted
    /**
     * in the enum tab every tab of the V_frame should be specified
     */
    enum tabs{};

    /**
     * creates Controller for each tab
     */
    void createTabControllers();

    /**
     * calls the required functions dependend on the id given
     * @param id identifier which button was pressed
     *           0: button x
     *           1: button y
     */

    /**
     * switches to the specified Tab
     * @param newTab integer of the newly selected tab
     */
    void notifyTabChange(int newTab);

    /**
     * notifies the Controller, that a slider was changed
     * @param sliderNo  integer to identify the slider that was changed
     * @param value integer to which the slider was changed to
     */
    void notifySlider(int sliderNo, int value);

    /**
     * notifies the effort controller to recalculate time
     */
    void notifyCalculate();

    /**
     * notifies the Controller that he should close the project and open the welcome window
     */
    void notifyClose();

    /**
     * notifies the Controller that he should save the project
     */
    void notifySave();

    /**
     * notifies the Controller that the next button was pressed
     */
    void notifyNext();

    /**
     * notifies the Controller that the last button was pressed
     */
    void notifyLast();

    /**
     * notifies the Controller that the user wants to close the program window
     */
    void notifyExit();

    I_C_tab getCurrentController();

    /**
     * notfies the controller that the new Button in Functional Reqirement Tab is pressed
     */
    void notifyFuncReqNEW();

    /**
     * notifies the controller that save Button in Functional Reqirement Tab is pressed
     */
    void notifyFuncReqSAVE();

    /**
     * notify Controller that selected List Item has changed
     * @param selectedID
     */
    public void notifyselectedListChange(String selectedID);
}
