package com.wildcodeschool.hibernate.springHibernateExample.utils;


import com.wildcodeschool.hibernate.springHibernateExample.entities.member;
import com.wildcodeschool.hibernate.springHibernateExample.repositories.memberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;




@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Aurélien");

    @Autowired
    private memberDao memberDao;

    @Override
    public void run(String... args) throws Exception{
        LOG.info("************");
        LOG.info("Objects in DB : " + memberDao.count());

        member newGandalf = new member("Gandalf", "Magician", 1500);
        LOG.info("******************");
        LOG.info(newGandalf + " has been created !");
        memberDao.save(newGandalf);
        LOG.info(newGandalf + " has been saved !");

        member newFrodon = new member("Frodon", "Porteur", 50);
        //newFrodon.setPower("Doesnt have any");
        LOG.info("******************");
        LOG.info(newFrodon + " has been created !");
        memberDao.save(newFrodon);
        LOG.info(newFrodon + " has been saved !");

        member newAragorn = new member("Aragorn", "King", 100);
        //newAragorn.setAge(200);
        LOG.info("******************");
        LOG.info(newAragorn + " has been created !");
        memberDao.save(newAragorn);
        LOG.info(newAragorn + " has been saved !");

        member tempUser = memberDao.findById(4L).get();
        LOG.info("****************");
        LOG.info("Forth member's name is "+ tempUser.getName());
        LOG.info("Forth member's power is "+ tempUser.getPower());
        LOG.info("Forth member's age is " + tempUser.getAge());

        LOG.info("******************");
        LOG.info("Users in list are ");
        for(member myUser : memberDao.findAll()) {
            LOG.info(myUser.toString());
        }

        memberDao.deleteById(4L);

        newGandalf.setAge(2000);
        memberDao.save(newGandalf);
        newAragorn.setPower("doesnt have any");
        memberDao.save(newAragorn);

        LOG.info("******************");
        LOG.info("Users in list are ");
        for(member myUser : memberDao.findAll()) {
            LOG.info(myUser.toString());
        }


    }
}
