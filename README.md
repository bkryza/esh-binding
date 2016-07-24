# esh-binding

A Leiningen template for writing [Eclipse Smart Home](http://www.eclipse.org/smarthome/) framework (and [openHAB 2](http://www.openhab.org/)) bindings in Clojure.

## Basic usage

This template allows creating ESH binding stubs in Clojure. It is based on the [Eclipse Smarthome Binding Archetype](https://github.com/eclipse/smarthome).

This template tries to adhere to both Leiningen/Clojure as well as Eclipse Smart Home project naming conventions. It is best to invoke it by providing a camel case name of the binding (thus requires the LEIN_BREAK_CONVENTION=1 environment variable to be set), however then uses camel case and small case where most appropriate.

```bash
LEIN_BREAK_CONVENTION=1 lein new esh-binding NewSmartThing
```

Since Leiningen template system only allows a single variable to be passed to the template generator (the project name), it will be needed to fix the generated sources in several places (package names, urls, vendor name, etc.).

The default java package name for binding generated from the above example will be:
```
org.newsmartthing.binding.newsmartthing
```


## Writing ESH bindings in Clojure

### Implementing handler
The main binding implementation functionality starts in `src/{{name}}_binding/handler.clj` file, namely in `-initialize()` and `-handleCommand()` functions.


## License

Copyright © 2016 Bartek Kryza (bkryza a gmail com)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
