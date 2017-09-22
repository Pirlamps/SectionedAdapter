package br.com.sectionadapter.section;

public class SectionItem implements SectionAdapterItem {

    public String section;

    public SectionItem(String section) {

        this.section = section!=null?section:"";
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof SectionItem && ((SectionItem) obj).section.equals(
                this.section);
    }
}
