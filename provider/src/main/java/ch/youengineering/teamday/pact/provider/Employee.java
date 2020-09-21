package ch.youengineering.teamday.pact.provider;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private String zip;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public static final class EmployeeBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String street;
        private String city;
        private String zip;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder anEmployee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder street(String street) {
            this.street = street;
            return this;
        }

        public EmployeeBuilder city(String city) {
            this.city = city;
            return this;
        }

        public EmployeeBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setStreet(street);
            employee.setCity(city);
            employee.setZip(zip);
            return employee;
        }
    }
}
