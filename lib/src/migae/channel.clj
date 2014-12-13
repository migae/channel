(ns migae.channel
  (:refer-clojure :exclude (contains? get))
  (:import [com.google.appengine.api.channel
            ChannelFailureException
            ChannelMessage
            ChannelPresence
            ChannelService
            ChannelServiceFactory

(defonce ^{:dynamic true} *channel-service* (atom nil))
(defonce ^{:dynamic true} *namespaced-channel-services* (atom {}))

(def policies {:always ChannelService$SetPolicy/SET_ALWAYS
               :add-if-not-present ChannelService$SetPolicy/ADD_ONLY_IF_NOT_PRESENT
               :replace-only ChannelService$SetPolicy/REPLACE_ONLY_IF_PRESENT})

(defn get-channel-service []
  (do (when (nil? @*channel-service*)
        (reset! *channel-service* (ChannelServiceFactory/getChannelService)))
      @*channel-service*))

