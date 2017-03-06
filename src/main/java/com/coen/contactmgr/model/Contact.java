package com.coen.contactmgr.model;
import javax.persistence.*;
@Entity
public class Contact {
    //We geven aan welke Kolomen we mee willen nemen naar de database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstname;
    @Column
    private  String lastname;
    @Column
    private String  email;
    @Column
    private Long phone;

    public Contact(ContactBuilder contactBuilder){
        this.firstname = contactBuilder.firstName;
        this.lastname = contactBuilder.lastname;
        this.email = contactBuilder.email;
        this.phone = contactBuilder.phone;
    }

    //toString() override
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }

    //region Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    //endregion

    public static class ContactBuilder{
        private int id;
        private String firstName;
        private  String lastname;
        private String  email;
        private Long phone;

        public ContactBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastname = lastName;
        }

        public ContactBuilder email(String email){
            this.email = email;
            return this;
        }

        public ContactBuilder phone(Long phone){
            this.phone = phone;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }

    }
}
