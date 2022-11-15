
public class Citizen {
    private String name;
    private String ic;
    private String state;
    private int age;
    private String category;
    private String stat1stDose;
    private String stat2ndDose;
    private String certificate;

    //Default Constructo
    public Citizen() {
        this.name = null;
        this.ic = null;
        this.state = null;
        this.age = 0;
        this.category = null;
    }

    //Normal Constructor
    public Citizen(String name, String ic, String state, int age, String category, String stat1stDose, String stat2ndDose, String certificate) {
        this.name = name;
        this.ic = ic;
        this.state = state;
        this.age = age;
        this.category = category;
        this.stat1stDose = stat1stDose;
        this.stat2ndDose = stat2ndDose;
        this.certificate = certificate;
    }

    //Set person Name
    public void setName(String name) {
        this.name = name;
    }

    //Set person IC
    public void setIc(String ic) {
        this.ic = ic;
    }

    //Set person state
    public void setState(String state) {
        this.state = state;
    }

    //Set person age
    public void setAge(int age) {
        this.age = age;
    }

    //Set person Category
    public void setCategory(String category) {
        this.category = category;
    }

    //Set person 1st dose status
    public void setStat1stDose(String status) {
        this.stat1stDose = status;
    }

    //Set person 2nd dose status
    public void setStat2ndDose(String status) {
        this.stat2ndDose = status;
    }

    //Set person certificate
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    //Get person name
    public String getName() {
        return(this.name);
    }

    //Get person IC
    public String getIc() {
        return(this.ic);
    }

    //Get person state
    public String getState() {
        return(this.state);
    }

    //Get person age
    public int getAge() {
        return(this.age);
    }

    //Get person category
    public String getCategory() {
        return(this.category);
    }

    //Get person 1st dose status
    public String getStat1stDose() {
        return(this.stat1stDose);
    }

    //Get person 2nd dose status
    public String getStat2ndDose() {
        return(this.stat2ndDose);
    }

    //Get person certificate
    public String getCertificate() {
        return(this.certificate);
    }

    //Print method
    public String toString() {
        return "Name: " + this.name + "\nIc: " + this.ic + "\nState: " + this.state + "\nAge: " + this.age + "\nCategory: " + this.category + "\n1st Dose: " + this.stat1stDose + "\n2nd Dose: " + this.stat2ndDose + "\nCertificate: " + this.certificate;
    }
}