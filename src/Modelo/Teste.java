/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Marco Cangela Garujo
 */
public class Teste {
      public static void criar(ArrayList dados){
        SessionFactory sessioFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
        Session sessao = sessioFactory.openSession();
        sessao.beginTransaction();
        
        dados.forEach(p-> {
            sessao.save(p);
        });

        sessao.getTransaction().commit();
        sessao.close();
       // sessioFactory.close();
    }
       
      public static void actualizar(Object o){
        SessionFactory sessioFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
        Session sessao = sessioFactory.openSession();
        sessao.beginTransaction();
       
        sessao.saveOrUpdate(o);
        sessao.getTransaction().commit();
        sessao.close();
        sessioFactory.close();
        
          
    }
    
      public static void remover(Object o){
        SessionFactory sessioFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
        Session sessao = sessioFactory.openSession();
        sessao.beginTransaction();
        
        sessao.delete(o);
        sessao.flush();
        sessao.close();
    }
    
      static ArrayList lerDados(){
        ArrayList dados = new ArrayList();
        SessionFactory sessioFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
        Session sessao = sessioFactory.openSession();
        sessao.beginTransaction();
        
        Criteria criterio = sessao.createCriteria(Pessoa.class);
        dados.addAll(criterio.list());
        
        
        sessao.getTransaction().commit();
        sessao.close();
        sessioFactory.close();
        
        return dados;
        
    }
    
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//        Session sessao=sessionFactory.openSession();
//        sessao.beginTransaction();
//     
//        Pessoa pessoaa = new Pessoa();
//        pessoaa.setNome("Maluco");
//        pessoaa.setIdade(19);
//        
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Leonardo");
//        pessoa.setIdade(20);
//        
//        sessao.save(pessoaa);
//        sessao.save(pessoa);
//       // sessao.getTransaction().commit();
//      
//        Criteria criterio = sessao.createCriteria(Pessoa.class);
//        List lista = criterio.list();
//        
//        
//        lista.forEach(n->{
//            System.out.println(n.toString()+"a");
//        });
//        Pessoa person = (Pessoa)sessao.get(Pessoa.class, 1);
//        
//        //System.out.println(person.getId()+" "+person.getNome());
//        
//        
//        
//          sessao.delete(pessoa);
//          sessao.flush();
//          sessao.close();
//          sessionFactory.close();

            ArrayList dados = new ArrayList();
            int i= 1;
             Pessoa p = new Pessoa();
            do {            
              String nome=  JOptionPane.showInputDialog(null,"Introduza o nome da Pessoa");
              p.setNome(nome);
              int idade =   Integer.parseInt(JOptionPane.showInputDialog(null,"Introduza a idade da Pessoa"));
              p.setIdade(idade);
              dados.add(p);
                criar(dados);
              i = Integer.parseInt(JOptionPane.showInputDialog(null,"Selecione a opcao desejada\n"
                      + "0- Finalizar\n"
                      + "1- Criar Pessoa\n"));
            } while (i!=0);
            
            lerDados().forEach(n->{
                JOptionPane.showMessageDialog(null,n.toString());
            });
            
            int k = Integer.parseInt(JOptionPane.showInputDialog(null,"Selecione o ID da pessoa que deseja apagar"));
            p.setId(k);
            remover(p);
            
            int v  = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduza o ID da pessao a editar"));
            p.setId(v);
            String nome=  JOptionPane.showInputDialog(null,"Introduza o nome da Pessoa");
            p.setNome(nome);
            int idade =   Integer.parseInt(JOptionPane.showInputDialog(null,"Introduza a idade da Pessoa"));
            p.setIdade(idade);
            dados.add(p);
            actualizar(p);
            
      }
}
