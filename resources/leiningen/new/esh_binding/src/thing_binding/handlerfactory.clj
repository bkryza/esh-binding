(ns {{name}}-binding.handlerfactory
  (:require [openhab-touchlyte-binding.constants :as const])
  (:import  (org.eclipse.smarthome.core.thing ThingTypeUID
                                              Thing)
            (org.eclipse.smarthome.core.thing.binding BaseThingHandlerFactory
                                                      ThingHandler)
            (org.{{name}}.binding.{{name}}.handler {{name-cc}}Handler)
            (java.util Collections Set)))

(gen-class
      :name "org.{{name}}.binding.{{name}}.internal.{{name-cc}}HandlerFactory"
      :init "init"
      :prefix "-"
      :extends org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory
      :constructors {[] []})

(defn -supportsThingType 
  [^ThingTypeUID thingTypeUID] 
  (.equals thingTypeUID const/THING_TYPE_SAMPLE))

(defn -createHandler
  [^Thing thing]
  (if (.equals (.getThingTypeUID thing) const/THING_TYPE_SAMPLE)
    ({{name-cc}}Handler. thing)
    nil))

