(defproject org.mobileink/migae.channel "0.1.0-SNAPSHOT"
  :description "migae channel - Clojure API for Google App Engine channel services."
  :url "https://github.com/migae/channel"
  :min-lein-version "2.0.0"
  :aot [#".*"]
  :omit-source true
  :jar-exlusions [#"~$" #".*clj"]
  :test-selectors {:stats :stats
                   :put :put
                   :miss :miss
                   :policy :policy
                   :del :del
                   :incr :incr}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [com.google.appengine/appengine-api-1.0-sdk "1.9.17"]
                 ;; [log4j "1.2.17" :exclusions [javax.mail/mail
                 ;;                              javax.jms/jms
                 ;;                              com.sun.jdmk/jmxtools
                 ;;                              com.sun.jmx/jmxri]]
                 ;; [org.slf4j/slf4j-log4j12 "1.6.6"]
                 [org.clojure/tools.logging "0.3.1"]]
  :profiles {:test {:dependencies [[com.google.appengine/appengine-api-labs "1.9.17"]
                                   [com.google.appengine/appengine-api-stubs "1.9.17"]
                                   [com.google.appengine/appengine-testing "1.9.17"]]}})

                                   ;; [ring-zombie "1.0.1"]]}})

;; // https://cloud.google.com/appengine/docs/java/tools/localunittesting#Java_Writing_tests_for_other_services
;; MyFirstTest demonstrates the simplest possible test setup, and for tests that have no dependency on App Engine APIs or local service implementations, you may not need anything more. However, if your tests or code under test have these dependencies, add the following JAR files to your testing classpath:

;; ${SDK_ROOT}/lib/impl/appengine-api.jar
;; ${SDK_ROOT}/lib/impl/appengine-api-labs.jar
;; ${SDK_ROOT}/lib/impl/appengine-api-stubs.jar
;; These JARs make the runtime APIs and the local implementations of those APIs available to your tests.

;; App Engine services expect a number of things from their execution environment, and setting these things up involves a fair amount of boilerplate code. Rather than set it up yourself, you can use the utilities in the com.google.appengine.tools.development.testing package. To use this package, add the following JAR file to your testing classpath:

;; ${SDK_ROOT}/lib/testing/appengine-testing.jar
