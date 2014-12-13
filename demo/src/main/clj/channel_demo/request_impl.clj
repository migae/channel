(ns channel-demo.request-impl
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clj-http.client :as http]
            [clojure.tools.logging :as log]
            [migae.memcache :as mc]
            [hiccup.page :refer [html5]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.route :as route])
  (:refer-clojure :exclude [contains? get]))

(defroutes request-routes

  ;; channel_presence enabled:
  (POST "/_ah/channel/connected/" []
       )

  ;; channel_presence enabled:
  (POST "/_ah/channel/disconnected/" []
        )

  (GET "/cljs" []
       ;; demo clojurescript
       (html5
        [:body
         [:p#clickable "Click me!"] ;; clickable: see core.cljs
         [:script {:src "js/goog/base.js" :type "text/javascript"}]
         [:script {:src "js/main.js" :type "text/javascript"}]
         [:script {:type "text/javascript"}
          "goog.require('webapp.core');"]]))

  (GET "/request/hello/:you" [you]
    (str (format "<h1>Howdy %s from channel-demo.request servlet!</h1>" you)
         "\n\n<a href='/'>home</a>"))

  (GET "/request/goodbye/:you" [you]
    (str (format "<h1>Adios %s from channel-demo.request servlet!</h1>" you)
         "\n\n<a href='/'>home</a>"))

  (route/not-found "<h1>Page not found</h1>"))

(def request-handler
  (-> #'request-routes
      wrap-params
      wrap-file-info
      ))

