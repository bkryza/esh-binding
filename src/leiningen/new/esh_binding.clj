(ns leiningen.new.esh-binding
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :as string]))

(def render (renderer "esh-binding"))

(defn esh-binding
  "FIXME: write documentation"
  [name]
  (let [data {:name-cc name
              :name (string/lower-case name)
              :sanitized (name-to-path (string/lower-case name))}]
    (main/info "Generating fresh 'lein new' esh-binding project.")
    (->files data
        ["src/{{sanitized}}_binding/constants.clj" 
          (render "src/thing_binding/constants.clj" data)]
        ["src/{{sanitized}}_binding/handler.clj" 
          (render "src/thing_binding/handler.clj" data)]
        ["src/{{sanitized}}_binding/handlerfactory.clj" 
          (render "src/thing_binding/handlerfactory.clj" data)]

        ["resources/OSGI-INF/{{name-cc}}HandlerFactory.xml" 
          (render "resources/OSGI-INF/ThingHandlerFactory.xml" data)]
          
        ["resources/ESH-INF/binding/binding.xml" 
          (render "resources/ESH-INF/binding/binding.xml" data)]
        ["resources/ESH-INF/i18n/{{sanitized}}_xx_XX.properties" 
          (render "resources/ESH-INF/i18n/thing_xx_XX.properties" data)]
        ["resources/ESH-INF/thing/thing-types.xml" 
          (render "resources/ESH-INF/thing/thing-types.xml" data)]
        
        ["project.clj" (render "project.clj" data)]
        ["README.md" (render "README.md" data)]

        ["lib/clojure-1.8.0.jar" (render "lib/clojure-1.8.0.jar")]
        ["lib/tools.logging-0.3.1.jar" (render "lib/tools.logging-0.3.1.jar")])))
