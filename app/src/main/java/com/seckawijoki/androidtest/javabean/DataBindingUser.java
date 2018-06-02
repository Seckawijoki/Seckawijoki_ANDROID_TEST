package com.seckawijoki.androidtest.javabean;

/**
 * Created by 瑶琴频曲羽衣魂 on 2018/5/29 at 10:57 under Windows-10 Professional.
 */
public class DataBindingUser {
  private String name;
  private String password;

  public DataBindingUser(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public DataBindingUser setName(String name) {
    this.name = name;
    return this;
  }

  public DataBindingUser setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }
}
