(defproject esh-{{name}}-binding "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  
  :url "FIXME: https://github.com/touchlyte/esh-binding"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
    
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.slf4j/slf4j-log4j12 "1.7.21"]
                 [org.eclipse.smarthome.core/org.eclipse.smarthome.core "0.8.0"]
                 [org.eclipse.smarthome.core/org.eclipse.smarthome.core.thing "0.8.0"]
                 [org.eclipse.smarthome.config/org.eclipse.smarthome.config.core"0.8.0"]
                 [org.osgi/org.osgi.core "6.0.0"]
                 [org.osgi/osgi.cmpn "6.0.0"]]
  
  :repositories [["repo-eclipse-releases" 
                    "https://repo.eclipse.org/content/repositories/releases/"],
                 ["repo-eclipse-snapshots" 
                    "https://repo.eclipse.org/content/repositories/snapshots/"]]
  
  :resource-paths ["resources"]

  :filespecs [{:type :path :path "lib/clojure-1.8.0.jar"},
              {:type :path :path "lib/tools.logging-0.3.1.jar"}]

  :manifest {
    "Bundle-ManifestVersion" "2"
    "Bundle-Name" "{{name-cc}} Binding"
    "Bundle-SymbolicName" "org.{{name}}.binding.{{name}};singleton:=true"
    "Bundle-Vendor" "FIXME: {{name-cc}} Vendor"
    "Bundle-Version" "0.1.0-SNAPSHOT"
    "Bundle-RequiredExecutionEnvironment" "JavaSE-1.7"
    "Bundle-ClassPath" "., clojure-1.8.0.jar, tools.logging-0.3.1.jar"
    "Import-Package" ~(fn [_] (clojure.string/join
                               ","
                               ["org.{{name}}.binding.{{name}}"
                                 "org.{{name}}.binding.{{name}}.handler"
                                 "org.eclipse.smarthome.config.core"
                                 "org.eclipse.smarthome.core.library.types"
                                 "org.eclipse.smarthome.core.thing"
                                 "org.eclipse.smarthome.core.thing.binding"
                                 "org.eclipse.smarthome.core.thing.binding.builder"
                                 "org.eclipse.smarthome.core.thing.type"
                                 "org.eclipse.smarthome.core.types"
                                 "org.slf4j"]))
    "Service-Component" ~(fn [_] (clojure.string/join
                               ","
                              [ "OSGI-INF/binding.xml" 
                                "OSGI-INF/genericbindingprovider.xml"]))
    "Export-Package"  ~(fn [_] (clojure.string/join
                               ", "
                              [ "org.{{name}}.binding.{{name}}" 
                                "org.{{name}}.binding.{{name}}.handler"]))}

  :aot :all)
