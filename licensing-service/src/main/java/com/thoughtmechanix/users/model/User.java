package com.thoughtmechanix.users.model;
import java.util.HashSet;

public class User{
  private String username;
  private String password;
  private HashSet<String> incomingChallengers;
  private HashSet<String> outgoingChallengers;
  private HashSet<String> acceptedChallengers;

  public User() {
    incomingChallengers = new HashSet<String>();
    outgoingChallengers = new HashSet<String>();
    acceptedChallengers = new HashSet<String>();
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

  public void addIncomingChallenger(String challenger) {
    incomingChallengers.add(challenger);
  }

  public void addOutgoingChallenger(String challenger) {
    outgoingChallengers.add(challenger);
  }

  public HashSet<String> getIncomingChallengers() {
    return incomingChallengers;
  }

  public HashSet<String> getOutgoingChallengers() {
    return outgoingChallengers;
  }

  public boolean acceptChallenger(String challenger) {
    if (!incomingChallengers.contains(challenger)) {
      return false;
    }
    incomingChallengers.remove(challenger);
    acceptedChallengers.add(challenger);
    return true;
  }

  public boolean challengeAccepted(String challenger) {
    if (!outgoingChallengers.contains(challenger)) {
      return false;
    }
    outgoingChallengers.remove(challenger);
    acceptedChallengers.add(challenger);
    return true;
  }
}
