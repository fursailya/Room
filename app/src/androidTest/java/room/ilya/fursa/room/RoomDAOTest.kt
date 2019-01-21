package room.ilya.fursa.room

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import room.ilya.fursa.room.db.AppDatabase
import room.ilya.fursa.room.db.model.Person
import room.ilya.fursa.room.db.PersonDAO


@RunWith(AndroidJUnit4::class)
class RoomDAOTest {
    private lateinit var db: AppDatabase
    private lateinit var dao: PersonDAO

    @Before
    fun setUp() {
        db = AppDatabase.create(InstrumentationRegistry.getTargetContext(), true)
        dao = db.personDAO()
        dao.insertPerson(Person("Alex", "Ivanov", 22, System.currentTimeMillis()))
    }

    @Test
    fun dbIsNotEmpty() {
        Assert.assertNotEquals(0, dao.all.size)
    }

    @Test
    fun personNameIsAlex() {
        Assert.assertEquals("Alex", dao.selectPersonById(1).personFirstName)
    }

    @Test
    fun personLastNameIsIvanov() {
        Assert.assertEquals("Ivanov", dao.selectPersonById(1).personLastName)
    }

    @Test
    fun insertNewPerson() {
        dao.insertPerson(Person("Ivam", "Sidorov", 55, System.currentTimeMillis()))
        Assert.assertEquals("Sidorov", dao.selectPersonById(2).personLastName)
    }



}
