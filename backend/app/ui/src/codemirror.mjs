import {EditorView, basicSetup} from "codemirror"
import {javascript} from "@codemirror/lang-javascript"
import {json} from "@codemirror/lang-json"

let editor = new EditorView({
  extensions: [basicSetup, javascript(), json()],
  parent: document.body
})
