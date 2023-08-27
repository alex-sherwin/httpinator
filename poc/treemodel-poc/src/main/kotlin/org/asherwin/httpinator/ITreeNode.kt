package org.asherwin.httpinator

import com.fasterxml.jackson.annotation.JsonProperty

interface ITreeNode {


  var type: String
    @JsonProperty("TYPE")
    get


}