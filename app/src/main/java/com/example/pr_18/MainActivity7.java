package com.example.pr_18;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity7 extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Product " + i, i * 1000,
                    R.drawable.ic_launcher, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине:";
        for (Product p : boxAdapter.getBox()) {
            if (p.box)
                result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
