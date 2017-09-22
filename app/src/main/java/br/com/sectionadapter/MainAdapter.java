package br.com.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.sectionadapter.section.DataItem;
import br.com.sectionadapter.section.SectionAdapter;
import br.com.sectionadapter.section.SectionItem;

public class MainAdapter extends SectionAdapter<TesteVO> {

    public MainAdapter(List<TesteVO> dataSet) {
        super(dataSet);
    }

    @Override public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.section_teste, parent, false);
        return new SectionViewHolder(view);

    }

    @Override public RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_teste, parent, false);
        return new ViewHolder(view);
    }

    @Override public void onBindSectionViewHolder(RecyclerView.ViewHolder holder, int position) {
        SectionItem item = getSection(position);
        SectionViewHolder holder2 = ((SectionViewHolder) holder);
        if (item != null) {
            holder2.tvSection.setText(item.section);
        }
    }

    @Override public void onBindDataViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataItem<TesteVO> item = getItem(position);
        ViewHolder holder1 = (ViewHolder) holder;
        if (item != null) {
            holder1.tvNome.setText(item.data.getName());
            holder1.tvCpf.setText(item.data.getCpf());
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNome;
        TextView tvCpf;

        ViewHolder(View v) {
            super(v);
            tvNome = v.findViewById(R.id.tv_nome);
            tvCpf = v.findViewById(R.id.tv_cpf);
        }
    }

    private static class SectionViewHolder extends RecyclerView.ViewHolder {

        TextView tvSection;

        SectionViewHolder(View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.tv_section);

        }
    }
}
