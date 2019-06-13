package com.wildcodeschool.hibernate.springHibernateExample.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String power;
    private int age;

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name +
                ", power=" + power + ", age=" + age + "]";
    }

    public member(){

    }

    public member(String name, String power, int age){
        this.name=name;
        this.power=power;
        this.age=age;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
