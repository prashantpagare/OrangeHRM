package org.orangehrm.pom.objects;

public class AddAndCreateEmployeeDetails {

    private String firstName;
    private String middleName;
    private String lastName;
    private String empID;
    private String newUserName;
    private String newPassword;
    private String newConfirmPassword;

    // Defualt
    public AddAndCreateEmployeeDetails(){}

    // Parameterized
    public AddAndCreateEmployeeDetails(String firstName,String middleName,String lastName,String empID,
                                       String newUserName,String newPassword,String newConfirmPassword){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.empID = empID;
        this.newUserName = newUserName;
        this.newPassword = newPassword;
        this.newConfirmPassword = newConfirmPassword;

    }

    public String getFirstName() {
        return firstName;
    }

    public AddAndCreateEmployeeDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public AddAndCreateEmployeeDetails setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddAndCreateEmployeeDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getNewUserName() {
        return newUserName;
    }

    public AddAndCreateEmployeeDetails setNewUserName(String newUserName) {
        this.newUserName = newUserName;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public AddAndCreateEmployeeDetails setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getNewConfirmPassword() {
        return newConfirmPassword;
    }

    public AddAndCreateEmployeeDetails setNewConfirmPassword(String newConfirmPassword) {
        this.newConfirmPassword = newConfirmPassword;
        return this;
    }



}
