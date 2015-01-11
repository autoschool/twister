package ru.qatools.school.twister.models;

import org.javalite.activejdbc.Model;

import java.security.Principal;
import java.sql.Timestamp;

/*
 * Created by ashchogoleva on 23.11.14.
 */
public class User extends Model implements Principal {

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        setString("name", name);
    }

    public String getPassHash() {
        return getString("pass_hash");
    }

    public void setPassHash(String hash) {
        setString("pass_hash", hash);
    }

    public Timestamp getCreatedAt() {
        return getTimestamp("created_at");
    }

    public String getPicture() {
        return getString("picture");
    }

    public void setPicture(String picture) {
        setString("picture", picture);
    }
}
