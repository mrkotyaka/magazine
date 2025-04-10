public class User extends ParentUser implements Customer, Vendor {

    private String customerName;
    private String vendorName;
    private String email;
    private boolean isCustomer;

    public User(String customerName){
        this.customerName = customerName;
        this.isCustomer = true;
    }

    public User(String vendorName, String email){
        this.vendorName = vendorName;
        this.email = email;
        this.isCustomer = false;
    }

    @Override
    public String getName() {
        if(isCustomer){
            return customerName;
        } else{
            return vendorName;
        }
    }

    @Override
    public String getEmail() {
        return email;
    }

    public boolean isCustomer() {
        return isCustomer;
    }
}
