package com.virja.mimsapp.DATA;

import java.io.Serializable;
import java.lang.String;

public class DataClass implements Serializable {
  private String template;

  private String url;

  public String getTemplate() {
    return this.template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
