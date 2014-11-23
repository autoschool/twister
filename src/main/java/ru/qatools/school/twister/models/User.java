package ru.qatools.school.twister.models;

import org.javalite.activejdbc.Model;

import java.sql.Timestamp;

/*
 * Created by ashchogoleva on 23.11.14.
 */
public class User extends Model{

  public String getName(){
      return getString("name");
  }

  public void setName(String name){
      setString("name",name);

  }

  public String getPassHash(){
      return getString("hash");
  }

  public void setPassHash(String hash){
      setString("hash", hash);
  }

    public Timestamp getCreatedAt() {
        return getTimestamp("created_at");
    }
}
