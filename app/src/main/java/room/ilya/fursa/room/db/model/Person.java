package room.ilya.fursa.room.db.model;

import android.arch.persistence.room.*;
import room.ilya.fursa.room.db.DateConverter;

@Entity(tableName = "Person")
@TypeConverters({DateConverter.class})
public class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "personId")
    public int id;

    @ColumnInfo(name = "personFirstName")
    public String personFirstName;

    @ColumnInfo(name = "personLastName")
    public String personLastName;

    @ColumnInfo(name = "personAge")
    public int personAge;

    @ColumnInfo(name = "personBirthDate")
    public long personBirthDate;

    public Person() {}

    public Person(String firstName, String lastName, int age, long birthDate) {
        this.personFirstName = firstName;
        this.personLastName = lastName;
        this.personAge = age;
        this.personBirthDate = birthDate;
    }


    public int getId() {
        return id;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public long getPersonBirthDate() {
        return personBirthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public void setPersonBirthDate(long personBirthDate) {
        this.personBirthDate = personBirthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personFirstName='" + personFirstName + '\'' +
                ", personLastName='" + personLastName + '\'' +
                ", personAge=" + personAge +
                '}';
    }
}
