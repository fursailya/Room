package room.ilya.fursa.room.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import room.ilya.fursa.room.db.model.Person;

import java.util.List;

import static room.ilya.fursa.room.BR.person;


@Dao
public interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person... people);

    @Delete
    void delete(Person person);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(Person person);

    @Query("DELETE FROM Person WHERE personId=:personId")
    void deleteById(int personId);

    @Query("SELECT * FROM Person WHERE personId=:personId")
    LiveData<Person> selectPersonById(int personId);

    @Query("SELECT * FROM Person")
    LiveData<List<Person>> getAll();

    @Query("SELECT COUNT(*) FROM Person")
    int getCounter();


}
