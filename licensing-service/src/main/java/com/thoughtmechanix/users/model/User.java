package com.thoughtmechanix.users.model;
import java.util.HashSet;

public class User{
  private String username;
  private String password;
  private HashSet<User> incomingChallengers;
  private HashSet<User> outgoingChallengers;

  public User() {
    incomingChallengers = new HashSet<User>();
    outgoingChallengers = new HashSet<User>();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User withUsername(String username){
    this.setUsername( username );
    return this;
  }

  public User withPassword(String password){
    this.setPassword( password );
    return this;
  }

  public void addIncomingChallenger(User challenger) {
    incomingChallengers.add(challenger);
  }

  public void addOutgoingChallenger(User challenger) {
    outgoingChallengers.add(challenger);
  }
}
