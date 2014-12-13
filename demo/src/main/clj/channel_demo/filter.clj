(ns channel-demo.filter
  (:import (javax.servlet Filter FilterChain FilterConfig
                          ServletRequest ServletResponse))
  (:gen-class :implements [javax.servlet.Filter]))

(defn -init [^Filter this ^FilterConfig cfg])

(defn -destroy [^Filter this])

(defn -doFilter
  [^Filter this
   ^ServletRequest rqst
   ^ServletResponse resp
   ^FilterChain chain]
  (do
    (require 'channel-demo.request-impl 'channel-demo.user-impl :reload);; :verbose)
    (.doFilter chain rqst resp)))
