package com.netdeal.netdeal.service;


import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {



    private int getPesoSenha() {

        //https://passwordmeter.com/

        // GeKpKrZal@2
        //"GeeKportal@20";
        String senha = "Geekportal@20";
        int letraMaiuscula = 0, letraMinuscula = 0, numero = 0, forcaSenha =0,subtrForcaSenha  = 0 ,special = 0, meta = 0 ;



        for(int i = 0; i < senha.length(); i++)
        {
            char ch = senha.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                letraMaiuscula++;
                if(letraMaiuscula > 0)
                    meta++;
            }
            else if (ch >= 'a' && ch <= 'z') {
                letraMinuscula++;
                if(letraMinuscula > 0)
                    meta++;
            }
            else if (ch >= '0' && ch <= '9') {
                numero++;
                if(numero > 0)
                    meta++;
            }
            else {
                special++;
                if(special > 0)
                    meta++;
            }
        }

        int  totalCaracter = senha.length();

        //Número de caracteres
        forcaSenha += (totalCaracter * 4 );
        //Letras maiúsculas
        forcaSenha += ((letraMaiuscula - totalCaracter)*2);
        //Letras minúsculas
        forcaSenha += ((letraMinuscula - totalCaracter)*2);
        //Números
        forcaSenha +=(numero*4);
        //caracteres especiais
        forcaSenha +=(special*6);
        //Middle numeros or Symbols
        forcaSenha +=((special + numero) * 2);

        //Requirements
        forcaSenha +=(meta * 2);

        //Apenas letras
        if( senha.length() == (letraMinuscula = letraMaiuscula ) ) {
            subtrForcaSenha += senha.length() ;
        }


        //Apenas números
        if( senha.length() == (numero) ) {
            subtrForcaSenha += senha.length() ;
        }



        System.out.println("Total characters : " + senha.length());
        System.out.println("letraMinuscula case letters : " + letraMinuscula);
        System.out.println("letraMaiuscula case letters : " + letraMaiuscula);
        System.out.println("numero : " + numero);
        System.out.println("Special characters : " + special);
        System.out.println("Força : " + special);


        return forcaSenha;
    }






}
