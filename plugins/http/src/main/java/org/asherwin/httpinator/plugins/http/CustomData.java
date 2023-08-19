package org.asherwin.httpinator.plugins.http;

public class CustomData {

  int data;

  public CustomData(int data) {
    this.data = data;
  }

  public String getData() throws Exception {
    Thread.sleep(2L);
    return String.format("my data: %d", data);
  }

}
