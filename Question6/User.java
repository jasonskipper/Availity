public class User {
    public String UserId;
    public String FirstName;
    public String LastName;
    public int version;
    public String InsuranceCompany;
    public User(String UserId, String FirstName, String LastName, int version, String InsuranceCompany) {
        this.UserId = UserId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.version = version;
        this.InsuranceCompany = InsuranceCompany;
    }
    public String prettyPrint() {
        return this.UserId + "," + this.FirstName + "," + this.LastName + "," + this.version + "," + this.InsuranceCompany + "\n";
    }
}