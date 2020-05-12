(ns lambdaisland.chui.shadowrun
  "Runner namespace to be used with shadow-cljs's :browser-test target.

  Not a 1989 fantasy tabletop game."
  {:dev/always true}
  (:require [lambdaisland.chui.runner :as runner]
            [lambdaisland.chui.ui :as ui]
            [lambdaisland.chui.test-data :as test-data]
            [lambdaisland.glogi :as log]
            [lambdaisland.glogi.console :as glogi-console]))

(test-data/capture-test-data!)

(glogi-console/install!)

(log/set-levels
 '{:glogi/root :debug
   lambdaisland :all
   lambdaisland.chui.interceptor :error})

(defn start []
  ;; for dev, enable this to update the UI on hot reload
  (ui/render! (.getElementById js/document "app"))
  (js/window.requestIdleCallback
   #(ui/run-tests)))

(defn stop [done]
  (runner/terminate! done))

(defn ^:export init []
  ;; (let [app (gdom/createElement "div")]
  ;;   (gdom/setProperties app #js {:id "chui-container"})
  ;;   (gdom/append js/document.body app))
  (ui/render! (.getElementById js/document "app"))
  (start))