package com.Kelp2.kelp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class user {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name="display_name")
    private String displayName;

    @Column(name="profile_pic")
    private String profilePic;

    @Column(name="fish_personality")
    private String fishPersonality;

    @Column(name="location")
    private String location;

    @Column(name="twitter")
    private String twitter;

    @Column(name="facebook")
    private String facebook;

    @Column(name="instagram")
    private String instagram;

    @Column(name="bio")
    private String bio;
}