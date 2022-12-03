package android.carolynbicycleshop.dolphinlive.Database;

import android.carolynbicycleshop.dolphinlive.dao.PartDAO;
import android.carolynbicycleshop.dolphinlive.dao.ProductDAO;
import android.carolynbicycleshop.dolphinlive.entities.Part;
import android.carolynbicycleshop.dolphinlive.entities.Product;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Project: Dolphin Live
 * Package: android.carolynbicycleshop.dolphinlive.Database
 * <p>
 * User: carolyn.sher
 * Date: 12/3/2022
 * Time: 4:08 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Database(entities = {Product.class, Part.class}, version=1, exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract PartDAO partDAO();

    private static  volatile  BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (BicycleDatabaseBuilder.class){
                if (INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),BicycleDatabaseBuilder.class,"MyBicycleDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }

            }

        }
        return INSTANCE;
    }
}
