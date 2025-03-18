/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author senacead
 */
public class Paciente {

    private int idPaciente;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private String telefone;
    private String cpf;
    private String rg;
    private String email;
    private int convenio;

    public Paciente() {

    }

    public Paciente(int idPaciente, String nome, String endereco, Date dataNascimento, String telefone, String cpf, String rg, String email, int convenio) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.convenio = convenio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    if (email == null || email.isEmpty()) {
        this.email = null; // Permite email nulo ou vazio
    } else if (!email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$")) {
        throw new IllegalArgumentException("E-mail inválido. O e-mail deve conter '@' e um domínio válido.");
    } else {
        this.email = email;
    }
}






    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        if (convenio <= 0) {
            throw new IllegalArgumentException("Convênio inválido. Selecione um convênio válido.");
        }
        this.convenio = convenio;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty() || nome.length() > 55) {
            throw new IllegalArgumentException("Nome inválido. O nome deve ter no máximo 55 caracteres.");
        }
        this.nome = nome.trim();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty() || endereco.length() > 200) {
            throw new IllegalArgumentException("Endereço inválido. O endereço deve ter no máximo 200 caracteres.");
        }
        this.endereco = endereco.trim();
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
    if (dataNascimento == null) {
        throw new IllegalArgumentException("Data de nascimento inválida. A data de nascimento é obrigatória.");
    }

    // Cria um Calendar para a data de nascimento
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dataNascimento);

    // Cria um Calendar para a data limite (1920)
    Calendar dataLimite = Calendar.getInstance();
    dataLimite.set(Calendar.YEAR, 1920);
    dataLimite.set(Calendar.MONTH, Calendar.JANUARY);
    dataLimite.set(Calendar.DAY_OF_MONTH, 1);

    // Verifica se a data de nascimento é inferior à data limite
    if (calendar.before(dataLimite)) {
        throw new IllegalArgumentException("Data de nascimento inválida. A data de nascimento deve ser igual ou posterior a 01/01/1920.");
    }

    this.dataNascimento = dataNascimento;
}


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone inválido. O telefone é obrigatório.");
        }
        // Remove todos os caracteres não numéricos do telefone
        telefone = telefone.replaceAll("[^0-9]", "");
        if (telefone.length() != 10 && telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido. O telefone deve ter 10 ou 11 dígitos.");
        }
        // Formata o telefone para (xx) xxxx-xxxx
        this.telefone = "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + "-" + telefone.substring(6);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF inválido. O CPF é obrigatório.");
        }
        // Remove todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. O CPF deve ter 11 dígitos.");
        }
        // Formata o CPF para xxx.xxx.xxx-xx
        this.cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
    if (rg == null || rg.trim().isEmpty()) {
        throw new IllegalArgumentException("RG inválido. O RG é obrigatório.");
    }
    // Remove todos os caracteres não numéricos do RG
    rg = rg.replaceAll("[^0-9]", ""); 
    // Valida se o RG tem 9 dígitos (após remover caracteres não numéricos)
    if (rg.length() != 9) {
        throw new IllegalArgumentException("RG inválido. O RG deve ter 9 dígitos.");
    }
    // Formata o RG para xx.xxx.xxx-x
    this.rg = rg.substring(0, 2) + "." + rg.substring(2, 5) + "." + rg.substring(5, 8) + "-" + rg.substring(8);
}


    public int getIdConvenio() {
        return convenio;
    }

    public void setIdConvenio(int convenio) {
        this.convenio = convenio;
    }

}
