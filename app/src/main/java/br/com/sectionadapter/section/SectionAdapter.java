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

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        RecyclerView.ViewHolder vh;
        if(viewType == DATA){
            vh = onCreateDataViewHolder(parent);
        }else{
            vh = onCreateSectionViewHolder(parent);
        }
        return vh;
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        if (getItemViewType(position) == DATA){
            onBindDataViewHolder(holder,position);
        }else{
            onBindSectionViewHolder(holder,position);
        }
    }

    @Override public int getItemCount() {
        return dataSet.size();
    }

    public abstract RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup parent);

    public abstract RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent);

    public abstract void onBindSectionViewHolder(RecyclerView.ViewHolder holder, int position);

    public abstract void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position);

}