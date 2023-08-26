# httpinator

## Building & Running via Local IDE

1. `pnpm install` in project root (pnpm workspaces) to install deps for****
   1. ***backend/app/ui***, which is used by **backend/app/pom.xml**'s to copy various NPM packages into **backend/app/target/classes/public** during Maven's **verify** phase.  These specific files are designed to be bundled into the final JAR artifact so they are available on the classpath and are served up by the WebServer as static JS & CSS assets. 
   2. **frontend**, which is an electron-forge based Electron project, meant to house the completely built application.
1. `npm run tailwind` from **backend/app/ui**'s package.json scripts.  This will run the TailwindCSS CLI to build a relevant tailwind.css file under **backend/app/ui/dist**
2. `mvn run verify` from either the project root (multi-module maven project root) or under **backend/app**.  This will ensure the **verify** maven goal runs which copies various JS & CSS assets from **backend/app/ui/dist** and **backend/app/ui/node_modules** into **backend/app/target/classes/public/assets** 
2. Run/Debug Kotlin main function `org.asherwin.httpinator.ApplicationITKt.main`

## Building & Packaging

TODO

# TODOs

* Run a Groovy LSP exposed via Spring Boot backend (JSON-RPC 2.0 protocol I think), see https://langserver.org/ for a list, probably use https://github.com/GroovyLanguageServer/groovy-language-server
* Hook up Groovy LSP to Monaco (see https://github.com/TypeFox/monaco-languageclient)
* Probably deprecate the non-variable Inter (non variable font from @fontsource/inter and inter.css files)****

# Pending PoC's

* Sandbox Groovy (see how Jenkins does this, use Groovy Compiler AST whitelisting, etc.)
* Provide contextual info (functions, objects) to the Groovy LSP for the Monaco editor to provide decent Groovy script editing
* 

# Possible Alternatives

1. Maybe try CodeMirror + LSPs too?

