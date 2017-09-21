package br.com.sectionadapter.section;

import android.support.annotation.NonNull;

public class SectionItem implements SectionAdapterItem {

    public String section;

    public SectionItem(@NonNull String section) {
        this.section = section;
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof SectionItem && ((SectionItem) obj).section.equals(
                this.section);
    }
}
