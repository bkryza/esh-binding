(ns {{name}}-binding.handlerfactory
  (:require [{{name}}-binding.constants :as const])
  (:import  (org.eclipse.smarthome.core.thing ThingTypeUID
                                              Thing)
            (org.eclipse.smarthome.core.thing.binding BaseThingHandlerFactory
                                                      ThingHandler)
            ({{binding-ns}}.{{name}}.handler {{name-cc}}Handler)
            (java.util Collections Set)))

(gen-class
      :name "{{binding-ns}}.{{name}}.internal.{{name-cc}}HandlerFactory"
      :init "init"
      :prefix "-"
      :extends org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory
      :constructors {[] []})

(defn -supportsThingType 
  [^ThingTypeUID thing-type-uid] 
  (.equals thing-type-uid const/thing-type-{{name}}))

(defn -createHandler
  [^Thing thing]
  (if (.equals (.getThingTypeUID thing) const/thing-type-{{name}})
    ({{name-cc}}Handler. thing)
    nil))

