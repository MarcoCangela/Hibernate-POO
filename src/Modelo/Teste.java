/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Marco Cangela Garujo
 */
public class Teste {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session sessao=sessionFactory.openSession();
        sessao.beginTransaction();
     
        Pessoa chissico = new Pessoa();
        chissico.setNome("Maluco");
        chissico.setIdade(19);
        
        Pessoa pessoa = new Pessoa();
        chissico.setNome("Leonardo");
        chissico.setIdade(20);
        
        sessao.save(chissico);
        sessao.save(pessoa);
        sessao.close();
        sessionFactory.close();
    }
}
