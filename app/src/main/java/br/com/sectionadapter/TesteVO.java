package br.com.sectionadapter;

import br.com.sectionadapter.section.Sectionable;

public class TesteVO implements Sectionable {

    private String name;
    private String cpf;

    public TesteVO(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override public String getSection() {
        if(name != null) {
            return String.valueOf(name.charAt(0));
        }
        return null;
    }
}
