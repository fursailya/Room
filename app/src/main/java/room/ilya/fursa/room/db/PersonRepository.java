package room.ilya.fursa.room.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import room.ilya.fursa.room.db.model.Person;

import java.util.List;

public class PersonRepository {
    private PersonDAO personDAO;
    private LiveData<List<Person>> personList;
    private AppDatabase db;

    public PersonRepository(Application application) {
        db = AppDatabase.create(application, false);
        personDAO = db.personDAO();
        personList = personDAO.getAll();
    }

    public LiveData<List<Person>> getAll() { return personList; }

    public void save(Person person) {
        new InsertTask(personDAO).execute(person);
    }

    public void deleteById(int id) { personDAO.deleteById(id); }

    public LiveData<Person> getById(int id) {
        return personDAO.selectPersonById(id);
    }

    public int getCounter() { return personDAO.getCounter(); }

    public void closeConnection() { db.close(); }

    private static class InsertTask extends AsyncTask<Person, Void, Void> {
        private PersonDAO dao;

        public InsertTask(PersonDAO personDAO) { this.dao = personDAO; }

        @Override
        protected Void doInBackground(Person... people) {
            dao.insertPerson(people[0]);
            return null;
        }
    }
}

