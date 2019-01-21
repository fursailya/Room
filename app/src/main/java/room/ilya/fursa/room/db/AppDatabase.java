package room.ilya.fursa.room.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.*;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import room.ilya.fursa.room.db.model.Person;

@Database(entities = {Person.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract PersonDAO personDAO();

    public static AppDatabase create(Context c, boolean inMemory) {
        if(inMemory) {
            instance = Room.inMemoryDatabaseBuilder(c.getApplicationContext(), AppDatabase.class)
                    .addMigrations(MIGRATION_1_2)
                    .build();
        } else {
            instance = Room.databaseBuilder(c.getApplicationContext(), AppDatabase.class, "person.db").build();
        }

        return instance;
    }

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Person ADD COLUMN personAge INTEGER DEFAULT 0 NOT NULL");
        }
    };
}
