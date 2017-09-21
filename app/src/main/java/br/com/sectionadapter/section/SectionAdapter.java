package br.com.sectionadapter.section;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public abstract class SectionAdapter<T extends Sectionable> extends RecyclerView.Adapter {

    private List<SectionAdapterItem> dataSet;
    protected static final int SECTION = 1;
    protected static final int DATA = 2;

    public SectionAdapter(List<T> dataSet) {
        this.dataSet = SectionAdapterUtil.preencherLista(dataSet);
    }

    @Override public int getItemViewType(int position) {
        if (dataSet.get(position) instanceof SectionItem) {
            return SECTION;
        } else {
            return DATA;
        }
    }

    @SuppressWarnings("unchecked")
    protected DataItem<T> getItem(int position){
        if(dataSet != null && dataSet.get(position) instanceof DataItem){
            return (DataItem<T>) dataSet.get(position);
        }
        return null;
    }

    protected SectionItem getSection(int position){
        if(dataSet != null && dataSet.get(position) instanceof SectionItem){
            return (SectionItem) dataSet.get(position);
        }
        return null;
    }

    @Override public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);


    @Override public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override public int getItemCount() {
        return dataSet.size();
    }


}