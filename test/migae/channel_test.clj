(ns migae.channel-test
  (:refer-clojure :exclude (contains? get))
  (:import [com.google.appengine.tools.development.testing
            LocalServiceTestConfig
            LocalServiceTestHelper
            LocalChannelServiceTestConfig])
           ;; [google.appengine.api.channel.InvalidValueException])
  (:require [clojure.test :refer :all]
            [migae.channel :as chan]
            [clojure.tools.logging :as log :only [trace debug info]]))

(defn- fixture
  [test-fn]
  (let [helper (LocalServiceTestHelper.
                (into-array LocalServiceTestConfig
                            [(LocalChannelServiceTestConfig.)]))]
    (do (.setUp helper)
        (chan/get-channel-service)
        (test-fn)
        (.tearDown helper))))

(use-fixtures :each fixture)

(deftest ^:init init
  (testing "Channel test init"
    (is (= com.google.appengine.api.channel.ChannelServiceImpl
           (class (chan/get-channel-service))))
    (is (= com.google.appengine.api.channel.ChannelServiceImpl
           (class @chan/*channel-service*)))))

;; api:
;; chan/statistics
;; chan/clear-all!
;; chan/contains?
;; chan/delete!
;; chan/get
;; chan/put!
;; chan/put-map!
;; chan/increment!
;; chan/increment-map!


(deftest basic-ops
  (is (not (= (chan/create-channel "foo") (chan/create-channel "foo")))))

;; ;; ################################
;; ;;    miss
;; (deftest ^:miss test-miss-1
;;   (testing "mc miss 1"
;;     (is (= (chan/has? "yar")
;;            false))
;;     (chan/miss "yar" "foo")
;;     (is (= (chan/has? "yar")
;;            true))))


;; ;; ################
;; ;;  replacement policies
;; ;;  options:  :always, :add-if-not-present, and :replace-only
;; (deftest ^:policy test-miss-policy-1
;;   (testing "mc miss policy 1"
;;     (is (= (:hit-count (chan/statistics)) 0))
;;     (is (= (:miss-count (chan/statistics)) 0))
;;     (is (= (chan/has? "yar") false))
;;     (is (= (:hit-count (chan/statistics)) 0))
;;     (is (= (:miss-count (chan/statistics)) 1))
;;     (chan/miss "yar" "foo" :always)
;;     (is (= (:item-count (chan/statistics)) 1))
;;     (is (= (chan/has? "yar") true))
;;     (is (= (:hit-count (chan/statistics)) 1))
;;     ))

;; (deftest ^:incr test-incr-2
;;   (testing "mc incr 2"
;;     (is (= (chan/contains? "yar") false))
;;     (chan/put! "yar" "foo")
;;     (try (chan/increment! "yar" 1)
;;          (catch Exception e
;;            (is (= "Non-incrementable value for key 'yar'"
;;                   (.getMessage e)))))
;;     ))
