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
      :name "org.{{name}}.binding.{{name}}.handler.{{name-cc}}Handler"
      :init init
      :prefix "-"
      :extends org.eclipse.smarthome.core.thing.binding.BaseThingHandler
      :constructors {[org.eclipse.smarthome.core.thing.Thing] []})



(defn -init 
  ([^org.eclipse.smarthome.core.thing.Thing thing] [[] thing]))


(defn -initialize
  [this]
  (do 
    (log/info "{{name-cc}} binding initialized")
    ;;
    ;; TODO: Implement custom initialization if necessary
    ;;
    (.updateStatus this ThingStatus/ONLINE)))


(defn -handleCommand
  [^ChannelUID channelUID ^Command command]
  (log/info "Handling TouchLyte command received on channel" (.getId channelUID))
  ;;
  ;; TODO: handle command received for channel
  ;;
  )