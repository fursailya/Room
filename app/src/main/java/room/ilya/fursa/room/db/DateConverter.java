package room.ilya.fursa.room.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public long from(Date date) { return date == null ? null : date.getTime(); }

    @TypeConverter
    public Date to(Long timestamp) { return timestamp == null ? null : new Date(timestamp); }
}
