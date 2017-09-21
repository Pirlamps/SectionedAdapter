package br.com.sectionadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_lista);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MainAdapter adapter = new MainAdapter(getDataSet());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private List<TesteVO> getDataSet(){
        List<TesteVO> lista = new ArrayList<>();
        lista.add(new TesteVO("aeste","123"));
        lista.add(new TesteVO(null,"123"));
        lista.add(new TesteVO("aeste1","1234"));
        lista.add(new TesteVO("beste2","1235"));
        lista.add(new TesteVO("aeste3","1236"));
        lista.add(new TesteVO("beste4","1237"));
        lista.add(new TesteVO("beste5","1238"));
        return lista;
    }
}
