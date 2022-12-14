package android.carolynbicycleshop.dolphinlive.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.carolynbicycleshop.dolphinlive.Database.Repository;
import android.carolynbicycleshop.dolphinlive.R;
import android.carolynbicycleshop.dolphinlive.entities.Part;
import android.carolynbicycleshop.dolphinlive.entities.Product;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PartDetails extends AppCompatActivity {
    EditText editName;
    EditText editPrice;
    String name;
    double price;
    int id;
    int productId;
    Part part;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_details);
        editName = findViewById(R.id.partname);
        editPrice = findViewById(R.id.partprice);
        id = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", -1.0);
        productId = getIntent().getIntExtra("prodID", -1);
        editName.setText(name);
        editPrice.setText(Double.toString(price));
        repository = new Repository(getApplication());
        Button button = findViewById(R.id.savepart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id == -1) {
                    part = new Part(0, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()), productId);
                    repository.insert(part);

                } else {
                    part = new Part(id, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()), productId);
                    repository.update(part);

                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_partdetails, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}