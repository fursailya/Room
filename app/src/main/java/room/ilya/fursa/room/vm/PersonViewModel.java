package room.ilya.fursa.room.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import room.ilya.fursa.room.db.model.Person;
import room.ilya.fursa.room.db.PersonRepository;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private PersonRepository repository;
    private LiveData<List<Person>> personList;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonRepository(application);
        personList = repository.getAll();
    }

    public LiveData<List<Person>> getPersonList() { return personList; }

    public void save(Person person) { repository.save(person); }

    public void deleteById(int id) { repository.deleteById(id); }

    public LiveData<Person> getById(int id) { return repository.getById(id); }
}
