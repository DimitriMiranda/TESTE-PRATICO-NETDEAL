package com.netdeal.netdeal.domain.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class FuncionarioHelper {

    static Logger logger = LoggerFactory.getLogger(FuncionarioHelper.class);


    /*Esse metodo tem como objetivo calcular a força de uma senha
      com base no criterios definidos no site  https://passwordmeter.com/
     */
    public  static  int getPesoSenha(String senha ) {



        // GeKpKrZal@2
        //"GeeKportal@20";
      // senha = "Geekportal@20";
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

        logger.info("Total characters : " + senha.length());
        logger.info("letraMinuscula case letters : " + letraMinuscula);
        logger.info("letraMaiuscula case letters : " + letraMaiuscula);
        logger.info("numero : " + numero);
        logger.info("Special characters : " + special);
        logger.info("Força Senha: " + forcaSenha);


        return forcaSenha;
    }
}
