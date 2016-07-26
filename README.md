# esh-binding

A Leiningen template for writing [Eclipse Smart Home](http://www.eclipse.org/smarthome/) framework (and [openHAB 2](http://www.openhab.org/)) bindings in Clojure.

## Basic usage

This template allows creating ESH binding stubs in Clojure. It is based on the [Eclipse Smarthome Binding Archetype](https://github.com/eclipse/smarthome).

This template tries to adhere to both Leiningen/Clojure as well as Eclipse Smart Home project naming conventions. It is best to invoke it by providing a camel case name of the binding (thus requires the LEIN_BREAK_CONVENTION=1 environment variable to be set), however then uses camel case and small case where most appropriate. 

Since Leiningen template system only allows a single variable to be passed to the template generator (the project name),Java namespace and vendor name for the generated binding can be overriden from defaults by providing the following environment variables:
* **ESH_BINDING_NS** - the java namespace for the binding
* **ESH_VENDOR** - the vendor (organization, company) developing the binding, in camel case

Example invocation:

```bash
LEIN_BREAK_CONVENTION=1 \
ESH_BINDING_NS=com.newsmartcompany.binding \
ESH_VENDOR=NewSmartCompany \
lein new esh-binding NewSmartThing
```


## Writing ESH bindings in Clojure

### Implementing handler
The main binding implementation functionality starts in `src/{{name}}_binding/handler.clj` file, namely in `-initialize()` and `-handleCommand()` functions:

```clojure
(defn -initialize
  "Initialize the thing. If done set status to ONLINE to indicate proper 
  working. Long running initialization should be done asynchronously in 
  background.
  
  When initialization can NOT be done set the status with more details for 
  further analysis. See also class ThingStatusDetail for all available status 
  details. Add a description to give user information to understand why thing 
  does not work as expected, for instance:

  (.updateStatus this ThingStatus.OFFLINE 
      ThingStatusDetail.CONFIGURATION_ERROR
      \"Can not access device as username and/or password are invalid\")
  "
  [this]
  (do 
    (log/info "NewSmartThing binding initialized")
    ;;
    ;; TODO: Implement custom initialization if necessary
    ;;
    (.updateStatus this ThingStatus/ONLINE)))


(defn -handleCommand
  "Handle command.

  If communication with thing fails for some reason, indicate that by setting 
  the status with detailed information:
  
  (.updateStatus this ThingStatus.OFFLINE
      ThingStatusDetail.COMMUNICATION_ERROR
      \"Could not control device at IP address x.x.x.x\")"
  [this ^ChannelUID channel-uid ^Command command]
  (log/info "Handling NewSmartThing command received on channel" (.getId channel-uid))
  ;;
  ;; TODO: handle command received for channel
  ;;
  )
```

### Implementing thing discovery
In order for the thing to be automatically discoverable, it is necessary to implement discovery service in `src/{{name}}_binding/discovery.clj` in `-startScan` method, which will be called by ESH when discovery is requested.

```clojure
(defn -startScan
  [this]
  (log/debug "Starting NewSmartThing discovery!")

  ;;
  ;; FIXME: Add actual discovery code here
  ;;
  (let [newsmartthing-name "newsmartthing-fixme"
        newsmartthing-uid (org.eclipse.smarthome.core.thing.ThingUID. 
                        const/thing-type-newsmartthing  "newsmartthing-fixme")]

    (.thing-discovered this 
        (.. org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder
              (create newsmartthing-uid)
              (withLabel "NewSmartThing")
              (build)))))
```

### Building and installing the binding
In order to compile the new binding from generated template simply execute:
```bash
lein jar
```
and copy the resulting jar into the `addons` folder in openHAB 2.

After starting openHAB 2 it should be visible in the UI, in particular if the automatic service discovery works, pressing `Find new things` should present the device. For instance after compiling and copying the binding generated from the above mentioned command, the following screen is visible:

![Discovery example screenshot](img/example-discovery.img)


## License

Copyright © 2016 Bartek Kryza (bkryza a gmail com)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
