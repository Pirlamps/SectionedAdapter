package br.com.sectionadapter.section;

public class DataItem<T> implements SectionAdapterItem {

    public T data;

    public DataItem(T data) {
        this.data = data;
    }


}
