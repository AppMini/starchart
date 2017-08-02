(ns ^:figwheel-no-load starchart.dev
  (:require
    [starchart.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
