/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.util.Calendar;
import java.util.List;
import modelo.ItemDaNota;
import modelo.NotaFiscal;

/**
 *
 * @author gusta
 */
public class NotaFiscalBuilder {
    NotaFiscal notaFiscal = new NotaFiscal();
    

    private NotaFiscalBuilder() {
    }
    
     public static NotaFiscalBuilder getBuilder(){
        return new NotaFiscalBuilder();//executa o construtor privado
    }
    
    public NotaFiscalBuilder ARazaoSocail(String razaoSocial){
        notaFiscal.setRazaoSocial(razaoSocial);
        return this;
    }
    public NotaFiscalBuilder OCnpj(String cnpj){
        notaFiscal.setCnpj(cnpj);
        return this;
    }
    public NotaFiscalBuilder ADataEmissao(){
        Calendar c = Calendar.getInstance();
        notaFiscal.setDataEmissao(c);
        return this;
    }
    public NotaFiscalBuilder OvalorBurto(Double valorBruto){
        notaFiscal.setValorBruto(valorBruto);
        return this;
    }
    public NotaFiscalBuilder OsImpostos(double impostos){
        notaFiscal.setImpostos(impostos);
        return this;
    }
    
    public NotaFiscalBuilder OsItens(ItemDaNota lista){
        notaFiscal.getItens().add(lista);
        return this;
    }
    public NotaFiscalBuilder AsObservacoes(String observacoes){
        notaFiscal.setObservacoes(observacoes);
        return this;
    }
    
    
     
     public NotaFiscalBuilder calcularValorBruto(){
        double impostos = notaFiscal.getImpostos();
        double somaDasNotas = 0;
        for (int i=0; i<notaFiscal.getItens().size(); i++){
            somaDasNotas += notaFiscal.getItens().get(i).getValor();
        }
        double valorBruto = impostos + somaDasNotas;
        notaFiscal.setValorBruto(valorBruto);
        return this;
     }
     
     public NotaFiscal build() {
            return notaFiscal;
        }
}
