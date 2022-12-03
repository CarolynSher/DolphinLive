package android.carolynbicycleshop.dolphinlive.dao;

import android.carolynbicycleshop.dolphinlive.entities.Part;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Project: Dolphin Live
 * Package: android.carolynbicycleshop.dolphinlive.dao
 * <p>
 * User: carolyn.sher
 * Date: 12/3/2022
 * Time: 4:04 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Dao
public interface PartDAO {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void insert(Part part);

    @Update
    void update(Part part);

    @Delete
    void delete(Part part);

    @Query("SELECT * FROM PARTS ORDER BY partID ASC")
    List<Part> getAllParts();

    @Query("SELECT * FROM PARTS WHERE productID= :productID ORDER BY partID ASC")
    List<Part> getAllAssociatadParts(int productID);
}
