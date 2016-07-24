(ns {{name}}-binding.constants
  (:import (org.eclipse.smarthome.core.thing ThingTypeUID)))

(def ^String BINDING_ID "{{name}}")

(def ^ThingTypeUID THING_TYPE_SAMPLE (ThingTypeUID. BINDING_ID "sample"))

(def ^String CHANNEL_1 "channel1")