package android.carolynbicycleshop.dolphinlive.dao;

import android.carolynbicycleshop.dolphinlive.entities.Product;

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
 * Time: 3:58 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Dao
public interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product product);
    @Update
    void update(Product product);
    @Delete
    void delete(Product product);
    @Query("SELECT * FROM PRODUCTS ORDER BY productID ASC")
    List<Product> getAllProducts();
}
