package by.pvt.bena;

public class PersonImpl {

    private String name;
    private String secondName;
    private AddressImpl address;

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public AddressImpl getAddress() {
        return address;
    }

    public void setAddress(AddressImpl address) {
        this.address = address;
    }

    public PersonImpl() {

    }
}
