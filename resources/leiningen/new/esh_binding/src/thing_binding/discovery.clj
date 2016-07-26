(ns {{name}}-binding.discovery
  (:require [clojure.tools.logging :as log]
            [{{name}}-binding.constants :as const])
  (:import  (org.eclipse.smarthome.core.thing ThingTypeUID
                                              Thing
                                              ChannelUID
                                              ThingStatus)
            (org.eclipse.smarthome.config.discovery AbstractDiscoveryService)
            (org.eclipse.smarthome.core.types Command)
            (org.slf4j Logger
                       LoggerFactory)
            (java.util Collections Set)))


(gen-class
      :name "{{binding-ns}}.{{name}}.discovery.{{name-cc}}DiscoveryService"
      :init init
      :prefix "-"
      :extends org.eclipse.smarthome.config.discovery.AbstractDiscoveryService
      :exposes-methods {thingDiscovered thing-discovered}
      :constructors {;; constructor parameters
                     [] 
                     ;; superconstructor parameters
                     [java.util.Set int]})

(def ^java.util.Set supported-uuids 
                    (Collections/singleton const/thing-type-{{name}}))

(def ^int discovery-time-seconds 30)

(defn -init 
  [] 
  [[supported-uuids discovery-time-seconds]] )


(defn -startScan
  [this]
  (log/debug "Starting {{name-cc}} discovery!")

  ;;
  ;; FIXME: Add actual discovery code here
  ;;
  (let [{{name}}-name "{{name}}-fixme"
        {{name}}-uid (org.eclipse.smarthome.core.thing.ThingUID. 
                        const/thing-type-{{name}}  "{{name}}-fixme")]

    (.thing-discovered this 
        (.. org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder
              (create {{name}}-uid)
              (withLabel "{{name-cc}}")
              (build)))))

