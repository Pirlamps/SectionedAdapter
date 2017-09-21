package br.com.sectionadapter.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SectionAdapterUtil {

    public static <T extends Sectionable> List<SectionAdapterItem> preencherLista(List<T> dados){
        List<SectionAdapterItem> listaParaAdapter = new ArrayList<>();

        sort(dados);
        for (T item : dados) {
            if(!listaParaAdapter.contains(new SectionItem(item.getSection()))){
                listaParaAdapter.add(new SectionItem(item.getSection()));
            }
            listaParaAdapter.add(new DataItem<>(item));
        }

        return listaParaAdapter;
    }

    private static <T extends Sectionable> List<T> sort(List<T> dados){

        Collections.sort(dados, new Comparator<T>() {
            @Override public int compare(T t, T t1) {
                String s1 = t.getSection() != null? t.getSection():"";
                String s2 = t1.getSection() != null? t1.getSection():"";
                return s1.compareTo(s2);
            }
        });
        return dados;
    }

}
