/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista5ex1cominterfacefluente;

import builder.NotaFiscalBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.ItemDaNota;
import modelo.NotaFiscal;

/**
 *
 * @author gusta
 */
public class Lista5Ex1ComInterfaceFluente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        NotaFiscal notaFiscal = NotaFiscalBuilder.getBuilder()
        .ARazaoSocail("Uma razao social")
        .OCnpj("43242124")
        .ADataEmissao()
        .OsImpostos(354)
        .OsItens(new ItemDaNota ("item 1",100.00))
        .OsItens(new ItemDaNota ("item 2",500.00))
        .OsItens(new ItemDaNota ("item 3",700.00))
        .calcularValorBruto()
        .AsObservacoes("algumas observacoes")
        .build();
        
        System.out.println("RazaoSocial: "+ notaFiscal .getObservacoes());
        System.out.println("Cnpj: "+ notaFiscal .getCnpj());
        System.out.println("Data Da Emissão: "+ notaFiscal .getDataEmissao());
        System.out.println("Impostos: "+ notaFiscal .getImpostos());
        for(int i=0; i < notaFiscal .getItens().size();i++){
           ItemDaNota itemDataNota = notaFiscal .getItens().get(i);
           System.out.println("Iten" + i + ": " + itemDataNota.getNome() + "," + itemDataNota.getValor());
        }
        System.out.println("Valor Bruto: "+ notaFiscal .getValorBruto());
        System.out.println("Observações: "+ notaFiscal .getObservacoes());
    }
    
}
