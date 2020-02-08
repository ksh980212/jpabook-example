package com.jpabook.modeling.demo;

import com.jpabook.modeling.demo.domain.member.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void logic(EntityManager em) {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        List<Member> resultList = query.getResultList();
        for (Member member : resultList) {
            System.out.println("member= " + member);
        }
    }


//    private static void logic(EntityManager em) {
//        String jpql = "select m from Member as m where m.name = 'kim'";
//        List<Member> resultList = em.createQuery(jpql, Member.class).getResultList();
//        for (Member member : resultList) {
//            System.out.println(member);
//        }
//    }

}
