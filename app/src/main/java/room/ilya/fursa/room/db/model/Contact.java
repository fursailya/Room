package room.ilya.fursa.room.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.SET_NULL;

@Entity(tableName = "Contact",
        foreignKeys = @ForeignKey(
                entity = Person.class,
                parentColumns = "personId",
                childColumns = "contactId",
                onDelete = SET_NULL
        ))
public class Contact {
    @PrimaryKey
    @ColumnInfo(name = "contactId")
    private int id;

    @ColumnInfo(name = "contactPhone")
    private String phone;

    @ColumnInfo(name = "contactEmail")
    private String email;

    @ColumnInfo(name = "contactPostIndex")
    private String postIndex;
}
