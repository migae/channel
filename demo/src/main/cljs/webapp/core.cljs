(ns webapp.core)

;; (enable-console-print!)

;; (println "Hello hi hi world!")

(defn handle-click [] (js/alert "Howdy hi there!"))

(def clickable (.getElementById js/document "clickable"))

(.addEventListener clickable "click" handle-click)
