//package com.coffee.coffee.Models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.util.List;
//
//@Entity
//@Table(name = "Role")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String Name;
//    @ManyToOne
//    @JoinColumn(name = "AcceptRole_id")
//    private AcceptRole acceptRole;
//
//    private Role(){}
//
//    public Role(String name, AcceptRole acceptRole) {
//        Name = name;
//        this.acceptRole = acceptRole;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//}
