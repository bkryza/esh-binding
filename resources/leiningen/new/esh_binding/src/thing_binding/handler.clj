(ns {{name}}-binding.handler
  (:require [clojure.tools.logging :as log])
  (:import  (org.eclipse.smarthome.core.thing ThingTypeUID
                                              Thing
                                              ChannelUID
                                              ThingStatus)
            (org.eclipse.smarthome.core.thing.binding BaseThingHandler
                                                      ThingHandler)
            (org.eclipse.smarthome.core.types Command)
            (org.slf4j Logger
                       LoggerFactory)
            (java.util Collections Set)))


(gen-class
      :name "{{binding-ns}}.{{name}}.handler.{{name-cc}}Handler"
      :init init
      :prefix "-"
      :extends org.eclipse.smarthome.core.thing.binding.BaseThingHandler
      :constructors {;; constructor parameters
                     [org.eclipse.smarthome.core.thing.Thing] 
                     ;; superconstructor parameters
                     [org.eclipse.smarthome.core.thing.Thing]})



(defn -init 
  [^org.eclipse.smarthome.core.thing.Thing thing] 
    [[thing]] )


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
    (log/info "{{name-cc}} binding initialized")
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
  (log/info "Handling {{name-cc}} command received on channel" (.getId channel-uid))
  ;;
  ;; TODO: handle command received for channel
  ;;
  )