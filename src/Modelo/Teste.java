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
     
        Pessoa pessoaa = new Pessoa();
        pessoaa.setNome("Maluco");
        pessoaa.setIdade(19);
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Leonardo");
        pessoa.setIdade(20);
        
        sessao.save(pessoaa);
        sessao.save(pessoa);
        //sessao.getTransaction().commit();
        sessao.close();
        sessionFactory.close();
    }
}
