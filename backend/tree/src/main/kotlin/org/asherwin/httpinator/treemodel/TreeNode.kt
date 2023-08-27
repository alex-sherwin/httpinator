package org.asherwin.httpinator.treemodel

import com.fasterxml.jackson.databind.JsonNode

class TreeNode(
  var type: String,
  var id: String,
  var displayName: String,
  var children: Array<TreeNode>,
//  var data: JsonNode?,
  var data: Map<String, JsonNode>,
)  {
  
}