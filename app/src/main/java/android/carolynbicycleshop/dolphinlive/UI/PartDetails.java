package android.carolynbicycleshop.dolphinlive.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.carolynbicycleshop.dolphinlive.R;
import android.os.Bundle;
import android.widget.EditText;

public class PartDetails extends AppCompatActivity {
    EditText editName;
    EditText editPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_details);

    }
}