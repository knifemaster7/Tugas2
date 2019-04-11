package com.example.tugas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    public String[] name = {"Patriaji Maulana", "Bambang Pamungkas", "Sulaiman Abidin", "Ucok Baba", "Patriaji Maulana", "Bambang Pamungkas", "Sulaiman Abidin", "Ucok Baba"};
    public String[] nim = {"F1D016068","F1D016008","F1D016028","F1D016062", "F1D016068","F1D016008","F1D016028","F1D016062" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridVIew);
        gridView.setAdapter(new GridAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("nim", nim[i]);
                startActivity(intent);

            }
        });

    }

    private class GridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return  name.length;
        }

        @Override
        public Object getItem(int i) {
            return  null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View gridViewData = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView nameShow = gridViewData.findViewById(R.id.dataName);
            TextView imgShow = gridViewData.findViewById(R.id.dataNIM);

            nameShow.setText(name[i]);
            imgShow.setText(nim[i]);

            return gridViewData;

        }
    }
}
