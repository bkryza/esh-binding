(ns {{name}}-binding.constants
  (:import (org.eclipse.smarthome.core.thing ThingTypeUID)))

(def ^String binding-id "{{name}}")

(def ^ThingTypeUID thing-type-{{name}} (ThingTypeUID. binding-id "{{name}}"))

(def ^String channel-1 "channel1")